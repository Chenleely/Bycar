package com.lzhihua.bycar.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.commonui.PopupDialog;
import com.lzhihua.bycar.databinding.ActivityTryCarBinding;
import com.lzhihua.bycar.ui.dialog.ChooseCarDialog;
import com.lzhihua.bycar.ui.dialog.ChooseCityDialog;
import com.lzhihua.bycar.util.UITools;

public class TryCarActivity extends BaseActivity implements PopupDialog.onDismissListener {
    private ActivityTryCarBinding activityTryCarBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransparentStatusBar();
        activityTryCarBinding = ActivityTryCarBinding.inflate(getLayoutInflater());
        setContentView(activityTryCarBinding.getRoot());
        activityTryCarBinding.tryCarTop.titleBack.setOnClickListener(view -> finish());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        lp.rightMargin = UITools.dip2px( 20);
        activityTryCarBinding.tryCarTop.topTv.setLayoutParams(lp);
        activityTryCarBinding.tryCarTop.topTv.setText("试驾行程");
        activityTryCarBinding.tryCarTop.topTv.setOnClickListener(view -> {

        });
        activityTryCarBinding.tryCarChooseCar.setOnClickListener(view -> {
            ChooseCarDialog chooseCarDialog=new ChooseCarDialog(TryCarActivity.this);
            chooseCarDialog.setListener(this);
            chooseCarDialog.show();
        });
        activityTryCarBinding.tryCarChooseCity.setOnClickListener(view -> {
            ChooseCityDialog chooseCityDialog=new ChooseCityDialog(TryCarActivity.this);
            chooseCityDialog.setListener(this);
            chooseCityDialog.show();
        });
    }

    @Override
    public void onDismiss(Bundle data) {
        String city=data.getString("city","");
        if(!TextUtils.isEmpty(city)){
            activityTryCarBinding.tryCarChooseCityName.setText(city);
        }
    }
}