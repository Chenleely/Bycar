package com.lzhihua.bycar.repo;

import com.alibaba.fastjson.JSON;
import com.lzhihua.bycar.bean.CarBean;
import com.lzhihua.bycar.bean.OrderBean;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.network.NetworkUtil;

import java.util.HashMap;

public class OrderRepo {
    private static final String Order_List="/sale_order/list";
    private static final String Create_Order="/sale_order/create";
    private static final String Cancel_Order="/sale_order/cancel";
    private static final String Order_pay="/sale_order/pay";

    //拉取订单列表
    public static void getOrderList(int limit, int offset, final DataSuccessListenter listenter){
        HashMap<String,String> params=new HashMap<>();
        params.put("Limit",limit+"");
        params.put("Offset",offset+"");
        NetworkUtil.getInstance().doGet(Order_List, params, new NetworkUtil.NetWorkListener() {
            @Override
            public void onSuccess(String response) {
                OrderBean.OrderList orderList= JSON.parseObject(response,OrderBean.OrderList.class);
                listenter.onDataSuccess(orderList);
            }

            @Override
            public void onFailed(String errorMsg) {
                listenter.onError(errorMsg);
            }
        });
    }

    //创建订单
    public static void createOrder(String id,String address,final DataSuccessListenter listenter){
        OrderBean.CreateOrder order=new OrderBean.CreateOrder();
        order.setAdress(address);
        order.setCarId(id);
        NetworkUtil.getInstance().doPost(Create_Order, JSON.toJSONString(order), new NetworkUtil.NetWorkListener() {
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

    //取消订单
    public static void cancelOrder(String orderId,final DataSuccessListenter listenter){
        OrderBean.CancelOrder cancelOrder=new OrderBean.CancelOrder(orderId);
        NetworkUtil.getInstance().doPost(Cancel_Order, JSON.toJSONString(cancelOrder), new NetworkUtil.NetWorkListener() {
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

    //订单支付
    public static void orderPay(String orderId,final DataSuccessListenter listenter){
        OrderBean.CancelOrder cancelOrder=new OrderBean.CancelOrder(orderId);
        NetworkUtil.getInstance().doPost(Order_pay, JSON.toJSONString(cancelOrder), new NetworkUtil.NetWorkListener() {
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

}
