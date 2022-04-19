package com.lzhihua.bycar.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.bean.AfterOrderBean;
import com.lzhihua.bycar.bean.CarBean;
import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.databinding.AfterOrderListBinding;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.repo.ImpairRepo;
import com.lzhihua.bycar.ui.adapter.AfterOrderAdapter;
import com.lzhihua.bycar.util.CommonTools;
import com.lzhihua.bycar.util.UITools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ImpairOrderActivity extends BaseActivity {
    private AfterOrderListBinding afterOrderListBinding;
    private AtomicInteger offset;
    private List<AfterOrderBean.AfterOrder.Result> afterList;
    private String[] impairString=new String[]{"待处理","维修中","待支付","已完成"};
    private String[] caringString=new String[]{"待处理","保养中","待支付","已完成"};
    //历史订单
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransparentStatusBar();
        afterOrderListBinding=AfterOrderListBinding.inflate(getLayoutInflater());
        setContentView(afterOrderListBinding.getRoot());
        offset=new AtomicInteger(1);
        afterList=new ArrayList<>();
        afterOrderListBinding.afterOrderListSpinner.setSelection(0);
        afterOrderListBinding.afterOrderListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                afterList.clear();
                queryData(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    private void updateUI(){
        afterOrderListBinding.afterOrderListContainer.removeAllViews();
        if (afterList!=null && afterList.size()>0){
            for (AfterOrderBean.AfterOrder.Result result:afterList){
                View itemView= LayoutInflater.from(this).inflate(R.layout.after_order_list_card, null,false);
                TextView status=itemView.findViewById(R.id.after_order_list_car_status);
                TextView carName=itemView.findViewById(R.id.after_order_list_car_name);
                TextView version=itemView.findViewById(R.id.after_order_list_car_version);
                TextView userName=itemView.findViewById(R.id.after_order_list_user_id);
                TextView address=itemView.findViewById(R.id.after_order_list_address);
                TextView createTime=itemView.findViewById(R.id.after_order_list_create_time);
                TextView updateTime=itemView.findViewById(R.id.after_order_list_update_time);
                TextView btn=itemView.findViewById(R.id.after_order_list_car_btn);
                carName.setText("车辆名称："+result.getCarResp().getName());
                version.setText("车辆版本："+result.getCarResp().getVersion());
                userName.setText("用户名："+result.getUserResp().getName());
                address.setText("维修城市："+result.getAddress());
                createTime.setText("创建时间："+CommonTools.formatUtcTime(result.getCreateTime()));
                updateTime.setText("更新时间："+CommonTools.formatUtcTime(result.getUpdateTime()));
                if (result.getStatus()==-1){
                    status.setText("已取消");
                }else if(offset.get()==0){
                    status.setText(impairString[result.getStatus()]);
                }else if (offset.get()==1){
                    status.setText(caringString[result.getStatus()]);
                }

                if (result.getStatus()==2){
                    btn.setVisibility(View.VISIBLE);
                    btn.setText("去支付");
                    btn.setOnClickListener(view -> {

                    });
                }else if (result.getStatus()==0){
                    btn.setVisibility(View.VISIBLE);
                    btn.setText("取消订单");
                    btn.setOnClickListener(view -> {
                        progressDialog.show();
                        ImpairRepo.cancelAfterOrder(result.getId(), new DataSuccessListenter() {
                            @Override
                            public void onDataSuccess(Object obj) {
                                CarBean.CommonResponse response=(CarBean.CommonResponse) obj;
                                if (response.getStatus().equals("success")){
                                    result.setStatus(-1);
                                    updateUI();
                                    UITools.showToast(ImpairOrderActivity.this,"取消成功");
                                }
                                progressDialog.dismiss();

                            }

                            @Override
                            public void onError(String error) {
                                progressDialog.dismiss();
                            }
                        });
                    });
                }else{
                    btn.setVisibility(View.GONE);
                }
                afterOrderListBinding.afterOrderListContainer.addView(itemView);
            }
        }
    }
    private void queryData(int type){
        progressDialog.show();
        ImpairRepo.getAfterOrders(10,1, type, new DataSuccessListenter() {
            @Override
            public void onDataSuccess(Object obj) {
                List<AfterOrderBean.AfterOrder.Result> tmp= (List<AfterOrderBean.AfterOrder.Result>) obj;
                if (tmp!=null){
                    for (AfterOrderBean.AfterOrder.Result  result:tmp){
                        afterList.add(result);
                    }
                }
                updateUI();
                offset.incrementAndGet();
                progressDialog.dismiss();
            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
            }
        });
    }
}