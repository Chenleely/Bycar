package com.lzhihua.bycar.common;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.List;

public class BaseViewModel extends ViewModel {
    private String mTag="BaseViewModel";
    private MutableLiveData<Boolean> isLogin=new MutableLiveData<>();//记录登陆状态，默认为false
    private MutableLiveData<Boolean> screenState=new MutableLiveData<>();//记录屏幕状态，true为打开，false为关闭
    public MutableLiveData<Boolean> getIsLogin() {
        return isLogin;
    }
    public MutableLiveData<Boolean> getScreenState() {
        return screenState;
    }

    private Bundle mData;
    public BaseViewModel(Bundle bundle){this.mData=bundle;}
}
