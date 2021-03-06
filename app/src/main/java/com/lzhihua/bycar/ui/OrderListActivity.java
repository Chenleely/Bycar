package com.lzhihua.bycar.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.bean.OrderBean;
import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.databinding.OrderListBinding;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.repo.OrderRepo;
import com.lzhihua.bycar.ui.adapter.OrderListAdapter;
import com.lzhihua.bycar.ui.presenter.UIShowListener;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends BaseActivity implements UIShowListener {
    private OrderListBinding orderListBinding;
    private OrderListAdapter orderListAdapter;
    private List<OrderBean.OrderList.Result> orderList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderListBinding=OrderListBinding.inflate(getLayoutInflater());
        setContentView(orderListBinding.getRoot());
        setWhiteStatusBar();
        orderListBinding.orderListBack.setOnClickListener(view -> finish());

        orderListAdapter=new OrderListAdapter(this);
        orderListAdapter.setOrderList(orderList);
        orderListAdapter.setUiShowListener(this);
        orderListBinding.orderListRecycler.setLayoutManager(new LinearLayoutManager(this));
        orderListBinding.orderListRecycler.setAdapter(orderListAdapter);
        requestData();
    }

    @Override
    public void showProgress() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void dismissProgress() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void requestData() {
        OrderRepo.getOrderList(10, 1, new DataSuccessListenter() {
            @Override
            public void onDataSuccess(Object obj) {
                OrderBean.OrderList orderBean=(OrderBean.OrderList) obj;
                orderList=orderBean.getData().getList();
                orderListAdapter.setOrderList(orderList);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

}