package com.lzhihua.bycar.ui;

import android.os.Bundle;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.common.BaseActivity;

public class ImpairOrderActivity extends BaseActivity {
    //历史订单
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransparentStatusBar();
        setContentView(R.layout.after_order_list);
    }
}