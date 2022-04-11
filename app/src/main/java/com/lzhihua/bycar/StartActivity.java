package com.lzhihua.bycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.commonui.CommonDialog;
import com.lzhihua.bycar.commonui.PopupDialog;
import com.lzhihua.bycar.ui.LoginDialog;
import com.lzhihua.bycar.ui.MainActivity;

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button button=(Button) findViewById(R.id.show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
//                LoginDialog loginDialog=new LoginDialog(StartActivity.this,0);
//                loginDialog.show();
            }
        });
    }
}