package com.lzhihua.bycar.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lzhihua.bycar.ui.LoginDialog;

public class BaseActivity extends AppCompatActivity{
//    protected NetworkUtil networkUtil=NetworkUtil.getInstance();
    public static final String loginAction="Bycar.ACTION.LOGIN";
    public static final String logoutAction="Bycar.ACTION.LOGOUT";
    protected BroadcastReceiver screenStateReceiver;
    protected BroadcastReceiver loginStateReceiver;//自定义广播
    private BaseViewModel mViewModel;
    public void setmViewModel(BaseViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBroadCastReceiver();
        registerReceiver(screenStateReceiver,new IntentFilter(Intent.ACTION_SCREEN_OFF));
        registerReceiver(screenStateReceiver,new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(loginStateReceiver,new IntentFilter(BaseActivity.loginAction));
        registerReceiver(loginStateReceiver,new IntentFilter(BaseActivity.logoutAction));
        MyViewModelFactory factory=new MyViewModelFactory();
        mViewModel=new ViewModelProvider(this,factory).get(BaseViewModel.class);
        mViewModel.getScreenState().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
//                  TODO:屏幕关闭时进行反馈
            }
        });
        mViewModel.getIsLogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean==false){
                    Intent intent=new Intent(getApplicationContext(), LoginDialog.class);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
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


    //注册登陆、屏幕状态广播接收器
    private void initBroadCastReceiver(){
        loginStateReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if (!TextUtils.isEmpty(action)){
                    switch (action){
                        case Intent.ACTION_SCREEN_ON:
                            mViewModel.getScreenState().postValue(true);
                            break;
                        case Intent.ACTION_SCREEN_OFF:
                            mViewModel.getScreenState().postValue(false);
                            break;
                        default:
                            break;
                    }
                }
            }
        };
        screenStateReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if (!TextUtils.isEmpty(action)){
                    switch (action){
                        case BaseActivity.loginAction:
                            mViewModel.getIsLogin().postValue(true);
                            break;
                        case BaseActivity.logoutAction:
                            mViewModel.getIsLogin().postValue(false);
                            break;
                        default:
                            break;
                    }
                }
            }
        };
    }

}
