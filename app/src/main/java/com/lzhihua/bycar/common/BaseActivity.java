package com.lzhihua.bycar.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lzhihua.bycar.network.NetworkUtil;
import com.lzhihua.bycar.ui.dialog.LoginDialog;
import com.lzhihua.bycar.ui.presenter.UIShowListener;
import com.lzhihua.bycar.util.SharedPrefTools;
import com.lzhihua.bycar.util.WeakRefHanlder;

public class BaseActivity extends AppCompatActivity implements Handler.Callback {
    //    protected NetworkUtil networkUtil=NetworkUtil.getInstance();
    public static boolean isLogin = false;
    protected WeakRefHanlder hanlder;
    private BaseViewModel mViewModel;
    protected ProgressDialog progressDialog;

    public void setmViewModel(BaseViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyViewModelFactory factory = new MyViewModelFactory();
        progressDialog = new ProgressDialog(this);
        hanlder=new WeakRefHanlder(this,getMainLooper());
        mViewModel = new ViewModelProvider(this, factory).get(BaseViewModel.class);
        mViewModel.getIsLogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean == false) {
                    Intent intent = new Intent(getApplicationContext(), LoginDialog.class);
                    startActivity(intent);
                }
            }
        });
        NetworkUtil.init(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        if (!checkLogin(this)) {
            LoginDialog loginDialog = new LoginDialog(this, 0);
            loginDialog.show();
        }
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void setWhiteStatusBar() {
        Window window = this.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置状态栏字体颜色为黑色
        window.setStatusBarColor(Color.TRANSPARENT);//状态栏透明
    }

    public void setTransparentStatusBar() {
        //5.0及以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = this.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            decorView.setSystemUiVisibility(option);
            this.getWindow().setStatusBarColor(Color.TRANSPARENT);
            //4.4到5.0
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = this.getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    public static boolean checkLogin(Context context) {
        boolean login = (boolean) SharedPrefTools.get(context, "is_login", false);
        return login;
    }

    public static void login(Context context) {
        SharedPrefTools.get(context, "is_login", true);
    }

    public static void logout(Context context) {
        SharedPrefTools.put(context, "is_login", false);
    }


    @Override
    public boolean handleMessage(@NonNull Message message) {
        return true;
    }
}
