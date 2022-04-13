package com.lzhihua.bycar.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lzhihua.bycar.databinding.ImpairFragmentBinding;
import com.lzhihua.bycar.ui.CareActivity;
import com.lzhihua.bycar.ui.ImpairActivity;
import com.lzhihua.bycar.ui.ImpairOrderActivity;
import com.lzhihua.bycar.ui.MainActivity;

public class ImpairFragment extends Fragment {
    private ImpairFragmentBinding impairFragmentBinding;
    private MainActivity mainActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        impairFragmentBinding=ImpairFragmentBinding.inflate(inflater);
        mainActivity.setTransparentStatusBar();
        impairFragmentBinding.impairFragCaringCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CareActivity.class);
            }
        });
        impairFragmentBinding.impairFragImpairCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ImpairActivity.class);
            }
        });
        impairFragmentBinding.impairFragBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ImpairOrderActivity.class);
            }
        });
        return impairFragmentBinding.getRoot();
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    private void startActivity(Class target){
        Intent intent=new Intent(getContext(),target);
        startActivity(intent);
    }
}
