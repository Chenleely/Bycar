package com.lzhihua.bycar;

import android.content.Intent;
import android.os.Bundle;

import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.ui.MainActivity;
import com.lzhihua.bycar.ui.ManagerActivity;
import com.lzhihua.bycar.ui.dialog.LoginDialog;

public class StartActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}