package com.lzhihua.bycar.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.databinding.AfterOrderListBinding;
import com.lzhihua.bycar.ui.adapter.AfterOrderAdapter;

public class ImpairOrderActivity extends BaseActivity {
    private AfterOrderAdapter afterOrderAdapter;
    private AfterOrderListBinding afterOrderListBinding;
    //历史订单
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransparentStatusBar();
        afterOrderListBinding=AfterOrderListBinding.inflate(getLayoutInflater());
        setContentView(afterOrderListBinding.getRoot());
        afterOrderListBinding.afterOrderListRecycler.setLayoutManager(new LinearLayoutManager(this));
        afterOrderListBinding.afterOrderListRecycler.setAdapter(afterOrderAdapter);
    }
}