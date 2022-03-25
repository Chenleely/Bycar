package com.lzhihua.bycar.network;

import android.content.Context;

import java.util.Map;

public interface IHttpRequest {
    void init(Context context);
    void doGet(String url, NetworkUtil.NetWorkListener listener);
    void doGet(String url, Map<String,String> params, NetworkUtil.NetWorkListener listener);
    void doGet(String url, Map<String,String> params, NetworkRepo.OkhttpOption okhttpOption, NetworkUtil.NetWorkListener listener);
    void doPost(String url, Map<String,String> params, NetworkUtil.NetWorkListener listener);
    void doPost(String url, Map<String,String> params, NetworkRepo.OkhttpOption okhttpOption, NetworkUtil.NetWorkListener listener);
    void cancel(String tag);
}
