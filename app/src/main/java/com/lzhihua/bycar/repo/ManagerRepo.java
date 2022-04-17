package com.lzhihua.bycar.repo;

import com.alibaba.fastjson.JSON;
import com.lzhihua.bycar.bean.CarBean;
import com.lzhihua.bycar.bean.ManagerBean;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.network.NetworkUtil;

import java.util.HashMap;
import java.util.Map;

public class ManagerRepo {
    private static final String GetAllOrders = "/sale_order/list_all";
    private static final String DealWithOrder = "/sale_order/process";
    private static final String FinishOrder = "/sale_order/finish";
    private static final String AddCar = "/car/create";
    private static final String DeleteCar = "/car/delete";
    private static final String GetTrycarList = "/test_drive/list_all";

    public static void GetOrderList(int limit, int offset, final DataSuccessListenter listenter) {
        Map<String, String> params = new HashMap<>();
        params.put("Limit", limit + "");
        params.put("Offset", offset + "");
        NetworkUtil.getInstance().doGet(GetAllOrders, params, new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                ManagerBean.SaleList saleList = JSON.parseObject(response, ManagerBean.SaleList.class);
                listenter.onDataSuccess(saleList);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onError(errorMsg);
            }
        });
    }

    public static void processOrder(int orderId, final DataSuccessListenter listenter){
        ManagerBean.OrderIdBean orderIdBean=new ManagerBean.OrderIdBean();
        orderIdBean.setOrderId(orderId);
        NetworkUtil.getInstance().doPost(DealWithOrder, JSON.toJSONString(orderIdBean), new NetworkUtil.NetWorkListener() {
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

    public static void finishOrder(int orderId, final DataSuccessListenter listenter){
        ManagerBean.OrderIdBean orderIdBean=new ManagerBean.OrderIdBean();
        orderIdBean.setOrderId(orderId);
        NetworkUtil.getInstance().doPost(FinishOrder, JSON.toJSONString(orderIdBean), new NetworkUtil.NetWorkListener() {
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

    public static void addCar(String name,String version,double price,String des,final DataSuccessListenter listenter){
        ManagerBean.AddCar addCar=new ManagerBean.AddCar();
        addCar.setName(name);
        addCar.setPrice(price);
        addCar.setVersion(version);
        addCar.setDescription(des);
        NetworkUtil.getInstance().doPost(AddCar, JSON.toJSONString(addCar), new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                CarBean.CommonResponse commonResponse=JSON.parseObject(response, CarBean.CommonResponse.class);
                listenter.onDataSuccess(response);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onError(errorMsg);
            }
        });
    }

    public static void deleteCar(int carId,final DataSuccessListenter listenter){
        ManagerBean.DeleteCar deleteCar=new ManagerBean.DeleteCar();
        deleteCar.setCarId(carId);
        NetworkUtil.getInstance().doPost(DeleteCar, JSON.toJSONString(deleteCar), new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                CarBean.CommonResponse commonResponse=JSON.parseObject(response, CarBean.CommonResponse.class);
                listenter.onDataSuccess(response);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onError(errorMsg);
            }
        });
    }

    public static void GetTrycarList(int limit, int offset, final DataSuccessListenter listenter) {
        Map<String, String> params = new HashMap<>();
        params.put("Limit", limit + "");
        params.put("Offset", offset + "");
        NetworkUtil.getInstance().doGet(GetTrycarList, params, new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                ManagerBean.TrycarList saleList = JSON.parseObject(response, ManagerBean.TrycarList.class);
                listenter.onDataSuccess(saleList);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onError(errorMsg);
            }
        });
    }
}
