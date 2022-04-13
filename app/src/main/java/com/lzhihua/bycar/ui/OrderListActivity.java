package com.lzhihua.bycar.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.databinding.OrderListBinding;

public class OrderListActivity extends BaseActivity {
    private OrderListBinding orderListBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderListBinding=OrderListBinding.inflate(getLayoutInflater());
        setContentView(orderListBinding.getRoot());
        setWhiteStatusBar();
        orderListBinding.orderListBack.setOnClickListener(view -> finish());
    }

}