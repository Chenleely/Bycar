package com.lzhihua.bycar.repo;

import com.alibaba.fastjson.JSON;
import com.lzhihua.bycar.bean.CarBean;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.network.NetworkUtil;

import java.util.HashMap;
import java.util.Map;

public class TryCarRepo {
    private static final String Car_list = "/car/list";//获取车辆列表
    private static final String Create_try_car = "/test_drive/create";
    private static final String Get_try_car_list = "/test_drive/list";
    private static final String Cancel_try_car = "/test_drive/cancel";

//    获得车辆列表
    public static void getCarlist(final DataSuccessListenter listenter) {
        NetworkUtil.getInstance().doGet(Car_list, new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                CarBean.CarList carList = JSON.parseObject(response, CarBean.CarList.class);
                listenter.onDataSuccess(carList);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onError(errorMsg);
            }
        });
    }

//    创建试驾行程
    public static void createTryCar(String carId,String address,String phone,final DataSuccessListenter listenter){
        CarBean.CreateTrycar createTrycar=new CarBean.CreateTrycar(carId,address,phone);
        NetworkUtil.getInstance().doPost(Create_try_car, JSON.toJSONString(createTrycar), new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                CarBean.CommonResponse commonResponse=JSON.parseObject(response, CarBean.CommonResponse.class);
                listenter.onDataSuccess(commonResponse);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onError(errorMsg);
            }
        });
    }

//  获得试驾列表
    public static void trycarList(int Limit,int Offset,final DataSuccessListenter listenter){
        Map<String ,String > params=new HashMap<>();
        params.put("Limit",Limit+"");
        params.put("Offset",Offset+"");
        NetworkUtil.getInstance().doGet(Get_try_car_list, params, new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                CarBean.TryCarList tryCarList=JSON.parseObject(response, CarBean.TryCarList.class);
                listenter.onDataSuccess(tryCarList);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onDataSuccess(errorMsg);
            }
        });
    }

//    取消试驾行程
    public static void cancelTrycar(String id,final DataSuccessListenter listenter){
        CarBean.IdCommon idCommon=new CarBean.IdCommon();
        idCommon.setId(id);
        NetworkUtil.getInstance().doPost(Cancel_try_car, JSON.toJSONString(idCommon), new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                CarBean.CommonBean commonBean=JSON.parseObject(response, CarBean.CommonBean.class);
                listenter.onDataSuccess(commonBean);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onError(errorMsg);
            }
        });
    }
}
