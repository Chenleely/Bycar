package com.lzhihua.bycar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.bean.ManagerBean;
import com.lzhihua.bycar.ui.viewmodel.ManageTrycarViewmodel;

import java.util.ArrayList;
import java.util.List;


public class ManageTrycarAdapter extends RecyclerView.Adapter<ManageTrycarAdapter.ManageTrycarHolder> {
    private List<ManagerBean.TrycarList.Result> carList=new ArrayList<>();
    private ManageTrycarViewmodel manageTrycarViewmodel;

    public void setManageTrycarViewmodel(ManageTrycarViewmodel manageTrycarViewmodel) {
        this.manageTrycarViewmodel = manageTrycarViewmodel;
    }

    private Context context;
    public ManageTrycarAdapter(Context context){
        this.context=context;
    }
    public void setCarList(List<ManagerBean.TrycarList.Result> carList) {
        if (carList!=null && carList.size()>0){
            for (ManagerBean.TrycarList.Result result:carList){
                this.carList.add(result);
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ManageTrycarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.manage_trycar_item,parent,false);
        return new ManageTrycarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManageTrycarHolder holder, int position) {
        ManagerBean.TrycarList.Result result=carList.get(position);
        holder.name.setText("试驾车型："+result.getCar().getName());
        holder.phone.setText("联系电话："+result.getPhone());
        holder.id.setText("订单id："+result.getId());
        holder.address.setText("试驾地址："+result.getAddress());
        holder.more.setOnClickListener(view -> {
            manageTrycarViewmodel.queryData();
        });
        if (position==carList.size()-1){
            holder.more.setVisibility(View.VISIBLE);
        }else {
            holder.more.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return carList==null? 0: carList.size();
    }

    protected class ManageTrycarHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView address;
        TextView id;
        TextView phone;
        TextView more;
        public ManageTrycarHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.manage_try_car_id);
            name=itemView.findViewById(R.id.manage_try_car_name);
            address=itemView.findViewById(R.id.manage_try_car_address);
            phone=itemView.findViewById(R.id.manage_try_car_tel);
            more=itemView.findViewById(R.id.manage_try_car_more);
        }
    }
}
