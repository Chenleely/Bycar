package com.lzhihua.bycar.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alibaba.fastjson.JSON;
import com.lzhihua.bycar.bean.CarBean;
import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.commonui.CommonDialog;
import com.lzhihua.bycar.databinding.ActivityManageCarBinding;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.repo.ManagerRepo;
import com.lzhihua.bycar.repo.TryCarRepo;
import com.lzhihua.bycar.ui.adapter.ManagerCarAdapter;
import com.lzhihua.bycar.ui.presenter.UIShowListener;
import com.lzhihua.bycar.util.UITools;

public class ManageCarActivity extends BaseActivity implements UIShowListener , SwipeRefreshLayout.OnRefreshListener {
    private ManagerCarAdapter managerCarAdapter;
    private ActivityManageCarBinding manageCarBinding;
    private int selectIndex = 0;//0:车辆列表  1:添加车辆

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransparentStatusBar();
        manageCarBinding = ActivityManageCarBinding.inflate(getLayoutInflater());
        setContentView(manageCarBinding.getRoot());
        managerCarAdapter = new ManagerCarAdapter(this);
        managerCarAdapter.setUiShowListener(this);
        manageCarBinding.manageCarRecycler.setAdapter(managerCarAdapter);
        manageCarBinding.manageCarRecycler.setLayoutManager(new LinearLayoutManager(this));
        manageCarBinding.manageCarSelectAdd.setOnClickListener(view -> {
            if (selectIndex == 0) {
                selectIndex = 1;
                updateSelect();
            }
        });
        manageCarBinding.manageCarSelectList.setOnClickListener(view -> {
            if (selectIndex == 1) {
                selectIndex = 0;
                updateSelect();
            }
        });
        manageCarBinding.manageCarTopBar.titleBack.setOnClickListener(view -> {
            finish();
        });
        manageCarBinding.manageCarAddcar.addCarDialogCarSubmit.setOnClickListener(view -> {
            String name=manageCarBinding.manageCarAddcar.addCarDialogCarName.getText().toString().trim();
            String version=manageCarBinding.manageCarAddcar.addCarDialogCarVersion.getText().toString().trim();
            String description=manageCarBinding.manageCarAddcar.addCarDialogCarDescription.getText().toString().trim();
            String price=manageCarBinding.manageCarAddcar.addCarDialogCarPrice.getText().toString().trim();
            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(version)
                    && !TextUtils.isEmpty(description) &&!TextUtils.isEmpty(price)){
                ManagerRepo.addCar(name, version, price, description, new DataSuccessListenter() {
                    @Override
                    public void onDataSuccess(Object obj) {
                        CarBean.CommonResponse commonResponse=(CarBean.CommonResponse) obj;
                        if (commonResponse!=null && commonResponse.getStatus().equals("success")){
                            UITools.showToast(ManageCarActivity.this,"创建成功");
                            requestData();
                        }
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
            }else{
                UITools.showToast(ManageCarActivity.this,"信息不完整");
            }
        });
        manageCarBinding.manageCarRefresh.setOnRefreshListener(this);
        manageCarBinding.manageCarRefresh.setProgressBackgroundColorSchemeColor(Color.parseColor( "#00bcbc"));
        manageCarBinding.manageCarRefresh.setColorSchemeColors(Color.parseColor("#ffffff"));
        updateSelect();
        requestData();
    }

    private void updateSelect() {
        String mainColor = "#383a51";
        String tipColor = "#00bcbc";
        manageCarBinding.manageCarSelectAdd.setTextColor(Color.parseColor(selectIndex == 0 ? mainColor : tipColor));
        manageCarBinding.manageCarAddcar.getRoot().setVisibility(selectIndex == 1 ? View.VISIBLE : View.GONE);
        manageCarBinding.manageCarSelectList.setTextColor(Color.parseColor(selectIndex == 1 ? mainColor : tipColor));
        manageCarBinding.manageCarRefresh.setVisibility(selectIndex == 0 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showProgress() {
        super.showProgress();
    }

    @Override
    public void dismissProgress() {
        super.dismissProgress();
    }

    @Override
    public void requestData() {
        showProgress();
        TryCarRepo.getCarlist(new DataSuccessListenter() {
            @Override
            public void onDataSuccess(Object obj) {
                dismissProgress();
                manageCarBinding.manageCarRefresh.setRefreshing(false);
                CarBean.CarList carList =( CarBean.CarList) obj;
                managerCarAdapter.setCarList(carList.getData().getList());
            }

            @Override
            public void onError(String error) {
                dismissProgress();
            }
        });
    }

    @Override
    public void onRefresh() {
        requestData();
    }
}