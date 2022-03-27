package com.lzhihua.bycar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.commonui.CommonDialog;

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initDialog();
    }
    private void initDialog() {
        final CommonDialog dialog = new CommonDialog(StartActivity.this);
        dialog.setMessage("这是一个自定义Dialog。")
                .setImageResId(R.mipmap.ic_launcher)
//                .setTitle("系统提示")
                .setSingle(false).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                dialog.dismiss();
                Toast.makeText(StartActivity.this,"xxxx",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
                Toast.makeText(StartActivity.this,"ssss",Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}