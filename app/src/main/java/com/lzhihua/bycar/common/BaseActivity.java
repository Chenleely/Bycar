package com.lzhihua.bycar.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.lzhihua.bycar.network.NetworkUtil;

public class BaseActivity extends AppCompatActivity{
    protected NetworkUtil networkUtil=NetworkUtil.getInstance();
    public String loginAction="Bycar.ACTION.LOGIN";
    public String logoutAction="Bycar.ACTION.LOGOUT";
    protected BroadcastReceiver screenStateReceiver;
    protected BroadcastReceiver loginStateReceiver;//自定义广播
    private BaseViewModel mViewModel;
    public void setmViewModel(BaseViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        registerReceiver(screenStateReceiver,new IntentFilter(Intent.ACTION_SCREEN_OFF));
        registerReceiver(screenStateReceiver,new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(loginStateReceiver,new IntentFilter(loginAction));
        registerReceiver(loginStateReceiver,new IntentFilter(logoutAction));
        super.onCreate(savedInstanceState);
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
    }

}
