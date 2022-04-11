package com.lzhihua.bycar.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.common.BaseActivity;

public class PurchaseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransparentStatusBar();
        setContentView(R.layout.activity_purchase);
    }
}