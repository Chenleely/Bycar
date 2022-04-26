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

    private Bundle mData;
    public BaseViewModel(Bundle bundle){this.mData=bundle;}

    public Bundle getmData() {
        return mData;
    }
}
