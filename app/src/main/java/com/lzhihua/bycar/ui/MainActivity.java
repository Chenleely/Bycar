package com.lzhihua.bycar.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.common.BaseActivity;
import com.lzhihua.bycar.databinding.ActivityMainBinding;
import com.lzhihua.bycar.ui.dialog.LoginDialog;
import com.lzhihua.bycar.ui.fragment.CarFragment;
import com.lzhihua.bycar.ui.fragment.ImpairFragment;
import com.lzhihua.bycar.ui.fragment.MineFragment;
import com.lzhihua.bycar.ui.fragment.MoreFragment;

public class MainActivity extends BaseActivity implements LoginDialog.DialogListener {
    private ActivityMainBinding mainBinding;
    private int currentIndex=0;//1:more  2:car   3:impair    4:mine
    private FragmentManager fragmentManager;
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWhiteStatusBar();
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        fragmentManager=getSupportFragmentManager();
        resources=getResources();
        initBottom();
        onBottomClick(1);
    }

    @Override
    protected void onResume() {
        checkLogin();
        super.onResume();
    }

    private void initBottom(){
        mainBinding.mainBottom.bottomMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBottomClick(1);
            }
        });
        mainBinding.mainBottom.bottomCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBottomClick(2);
            }
        });
        mainBinding.mainBottom.bottomImpair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBottomClick(3);
            }
        });
        mainBinding.mainBottom.bottomMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBottomClick(4);
            }
        });
    }
    private void onBottomClick(int index){
        if(currentIndex!=index) {
            resetImage(currentIndex);
            switch (index){
                case 1:
                    currentIndex=1;
                    mainBinding.mainBottom.bottomMoreIv.setImageDrawable(resources.getDrawable(R.drawable.ic_more_select));
                    replaceFragment(new MoreFragment());
                    break;
                case 2:
                    currentIndex=2;
                    mainBinding.mainBottom.bottomCarIv.setImageDrawable(resources.getDrawable(R.drawable.ic_car_select));
                    CarFragment carFragment=new CarFragment();
                    carFragment.setmActivity(MainActivity.this);
                    replaceFragment(carFragment);
                    break;
                case 3:
                    currentIndex=3;
                    mainBinding.mainBottom.bottomImpairIv.setImageDrawable(resources.getDrawable(R.drawable.ic_impair_select));
                    ImpairFragment impairFragment=new ImpairFragment();
                    impairFragment.setMainActivity(this);
                    replaceFragment(impairFragment);
                    break;
                case 4:
                    currentIndex=4;
                    mainBinding.mainBottom.bottomMineIv.setImageDrawable(resources.getDrawable(R.drawable.ic_mine_select));
                    replaceFragment(new MineFragment());
                    break;
            }
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container,fragment).commit();
    }

    private void resetImage(int index){
        switch (index){
            case 0:
                break;
            case 1:
                mainBinding.mainBottom.bottomMoreIv.setImageDrawable(resources.getDrawable(R.drawable.ic_more_not_select));
                break;
            case 2:
                mainBinding.mainBottom.bottomCarIv.setImageDrawable(resources.getDrawable(R.drawable.ic_car_not_select));
                break;
            case 3:
                mainBinding.mainBottom.bottomImpairIv.setImageDrawable(resources.getDrawable(R.drawable.ic_impair_not_select));
                break;
            case 4:
                mainBinding.mainBottom.bottomMineIv.setImageDrawable(resources.getDrawable(R.drawable.ic_mine_not_select));
                break;
        }
    }
    private void checkLogin(){
        if (BaseActivity.isLogin==false){
            LoginDialog loginDialog=new LoginDialog(this,0);
            loginDialog.setListener(this);
            loginDialog.show();
        }
    }

    @Override
    public void onDismiss(boolean isSuccess) {

    }
}