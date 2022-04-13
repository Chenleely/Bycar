package com.lzhihua.bycar.repo;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.lzhihua.bycar.bean.CityList;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.network.NetworkUtil;

import java.util.HashMap;

public class CityRepo {
    private static final String key = "V4BBZ-EZDLX-5IY4T-7LCOK-RJJ35-SBF5U";
    private static final String tag = "city_repo";
    private static final String provinceApi = "https://apis.map.qq.com/ws/district/v1/list";
    private static final String citiesApi = "https://apis.map.qq.com/ws/district/v1/getchildren";

    public static void queryProvinces(final DataSuccessListenter listenter) {
        HashMap<String, String> keyMap = new HashMap<>();
        keyMap.put("key", key);
        NetworkUtil.getInstance().doGet(provinceApi, keyMap, new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                CityList.Province province = (CityList.Province) JSON.parseObject(response, CityList.Province.class);
                listenter.onDataSuccess(province);
            }

            @Override
            public void onFailed(String errorMsg) {
                Log.e(tag, errorMsg);
            }
        });
    }

    public static void queryChildrennCity(String id, final DataSuccessListenter listenter) {
        HashMap<String, String> keyMap = new HashMap<>();
        keyMap.put("key", key);
        keyMap.put("id", id);
        NetworkUtil.getInstance().doGet(citiesApi, keyMap, new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                CityList.ChildrenCity city = (CityList.ChildrenCity) JSON.parseObject(response, CityList.ChildrenCity.class);
                listenter.onDataSuccess(city);
            }

            @Override
            public void onFailed(String errorMsg) {
                Log.e(tag, errorMsg);
            }
        });
    }
}
