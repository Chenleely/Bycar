package com.lzhihua.bycar.network;

import android.content.Context;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;

public interface IHttpRequest {
    void doGet(String url, NetworkUtil.NetWorkListener listener);
    void doGet(String url, Map<String,String> params, NetworkUtil.NetWorkListener listener);
    void doGet(String url, Map<String,String> params, NetworkRepo.OkhttpOption okhttpOption, NetworkUtil.NetWorkListener listener);

    void doPost(String url, Map<String,String> params, NetworkUtil.NetWorkListener listener);
    void doPost(String url, Map<String,String> params, NetworkRepo.OkhttpOption okhttpOption, NetworkUtil.NetWorkListener listener);
    void doPost(String url,  Map<String,String> params,File file, MediaType type,NetworkUtil.NetWorkListener listener);
    void doPost(String url, String json, NetworkUtil.NetWorkListener listener);
    void doPost(String url,String json, NetworkUtil.NetWorkListener listener,Map<String,String> params);
    void cancel(String tag);
}
