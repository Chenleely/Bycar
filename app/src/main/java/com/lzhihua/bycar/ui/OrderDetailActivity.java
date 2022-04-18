package com.lzhihua.bycar.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.bean.CarBean;
import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.commonui.PopupDialog;
import com.lzhihua.bycar.databinding.OrderDetailBinding;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.repo.OrderRepo;
import com.lzhihua.bycar.ui.dialog.ChooseCityDialog;
import com.lzhihua.bycar.util.UITools;

public class OrderDetailActivity extends BaseActivity implements PopupDialog.onDismissListener {
//    订单生成
    private CarBean.CarList.CarListSubData carBean;
    private OrderDetailBinding orderDetailBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWhiteStatusBar();
        orderDetailBinding=OrderDetailBinding.inflate(getLayoutInflater());
        setContentView(orderDetailBinding.getRoot());
        carBean= (CarBean.CarList.CarListSubData) getIntent().getSerializableExtra("car_bean");
        if (carBean==null){
            finish();
        }
        orderDetailBinding.createOrderTop.topTv.setText("创建订单");
        orderDetailBinding.createOrderName.setText("车型：NIO "+carBean.getName());
        orderDetailBinding.createOrderPrice.setText("总价：￥ "+carBean.getPrice()*10000);
        orderDetailBinding.createOrderVersion.setText("版本："+carBean.getVersion());
        orderDetailBinding.createOrderImg.setImageDrawable(UITools.getDrawable(getResources(),carBean.getName()));
        orderDetailBinding.createOrderCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseCityDialog chooseCityDialog=new ChooseCityDialog(OrderDetailActivity.this);
                chooseCityDialog.setDialogType("chooseCityDialog");
                chooseCityDialog.setListener(OrderDetailActivity.this);
                chooseCityDialog.show();
            }
        });
        orderDetailBinding.createOrderCancel.setOnClickListener(view -> {
            finish();
        });
        orderDetailBinding.createOrderTop.titleBack.setOnClickListener(view -> {
            finish();
        });
        orderDetailBinding.createOrderCommit.setOnClickListener(view -> {
            TextView cityTv=orderDetailBinding.createOrderCity.findViewById(R.id.order_car_city_name);
            EditText receiverTv=orderDetailBinding.createOrderReceiver.findViewById(R.id.create_order_receiver_name);
            EditText phoneTv=orderDetailBinding.createOrderPhone.findViewById(R.id.create_order_phone_number);
            if (TextUtils.isEmpty(cityTv.getText().toString()) || TextUtils.isEmpty(receiverTv.getText().toString()) || TextUtils.isEmpty(phoneTv.getText().toString())){
                UITools.showToast(OrderDetailActivity.this,"信息不完整哦..");

            }else {
                progressDialog.show();
                OrderRepo.createOrder(carBean.getId(), cityTv.getText().toString().trim(), new DataSuccessListenter() {
                    @Override
                    public void onDataSuccess(Object obj) {
                        orderDetailBinding.createOrderCancel.setVisibility(View.GONE);
                        orderDetailBinding.createOrderCommit.setVisibility(View.GONE);
                        orderDetailBinding.createOrderPay.setVisibility(View.VISIBLE);
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(String error) {
                        UITools.showToast(OrderDetailActivity.this,"未知错误，稍后再试");
                        progressDialog.dismiss();
                    }
                });
            }


        });
        orderDetailBinding.createOrderPay.setOnClickListener(view -> {
            progressDialog.show();
            OrderRepo.orderPay("" + carBean.getId(), new DataSuccessListenter() {
                @Override
                public void onDataSuccess(Object obj) {
                    UITools.showToast(OrderDetailActivity.this, "支付成功");
                    progressDialog.dismiss();
                    finish();
                }

                @Override
                public void onError(String error) {
                    UITools.showToast(OrderDetailActivity.this, "支付失败");
                    progressDialog.dismiss();
                }
            });
        });
    }

    @Override
    public void onDismiss(Bundle data,String type) {
        if (type.equals("chooseCityDialog")){
            String city=data.getString("city","");
            if(!TextUtils.isEmpty(city)){
                TextView cityTv=orderDetailBinding.createOrderCity.findViewById(R.id.order_car_city_name);
                cityTv.setText(city);
            }
        }
    }
}