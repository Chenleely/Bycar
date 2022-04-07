package com.lzhihua.bycar.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.commonui.CommonDialog;
import com.lzhihua.bycar.commonui.PopupDialog;
import com.lzhihua.bycar.databinding.CreateUserBinding;
import com.lzhihua.bycar.databinding.LoginBinding;

public class LoginDialog extends PopupDialog {
    private int TYPE=0;//0:注册 1:登录 2:忘记密码
//登陆
    private ViewStub loginStub;
    private View loginView;
//注册
    private ViewStub registerStub;
    private View registerView;
//    忘记密码
    private ViewStub forgetStub;
    private View forgetView;

    public LoginDialog(Context context,int type) {

        super(context, R.layout.activity_login,0);
        registerStub=(ViewStub) mView.findViewById(R.id.login_create_user);
        loginStub=(ViewStub) mView.findViewById(R.id.login_login_user);
        forgetStub=(ViewStub) mView.findViewById(R.id.forget_psw);
        //可能存在token过期的情况需要重新登陆，首次进入默认未注册
        switch (type){
            case 0:
                registerView=registerStub.inflate();
                initRegister();
                break;
            case 1:
                loginView=loginStub.inflate();
                initLogin();
                break;
        }
    }
    private void initRegister(){
//        createUserBinding=CreateUserBinding.inflate(LayoutInflater.from(context));
        Button changeToLogin=(Button) registerView.findViewById(R.id.create_user_change_login);
        Button registerBtn=(Button) registerView.findViewById(R.id.create_user_register);
        EditText createUserName=registerView.findViewById(R.id.create_user_name);
        EditText createUserPsw=registerView.findViewById(R.id.create_user_psw);
        EditText createUserPswConfirm=registerView.findViewById(R.id.create_user_psw_confirm);
        EditText createUserEmail=registerView.findViewById(R.id.create_user_email);
        changeToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerStub.setVisibility(View.GONE);
                loginView=loginStub.inflate();
                initLogin();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=createUserName.getText().toString().trim();
                String password=createUserPsw.getText().toString().trim();
                String passConf=createUserPswConfirm.toString().trim();
                String mail=createUserEmail.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(passConf) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(mail)){
                    if (!passConf.equals(password) ){
                        showToast("密码前后不一致，请重新确认");
                    }else {
//                        TODO：注册接口
                    }
                }else{
                    showToast("信息不完整，请输入完整的账户名、邮箱、密码");
                }
            }
        });
    }

    private void initLogin(){
        TextView loginBtn= (TextView) loginView.findViewById(R.id.login_login_btn);
        TextView forgetBtn=(TextView) loginView.findViewById(R.id.login_forget_psw);
        EditText loginUserName=loginView.findViewById(R.id.login_user_name);
        EditText loginPsw=loginView.findViewById(R.id.login_psw);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=loginUserName.getText().toString().trim();
                String password=loginPsw.getText().toString().trim();
                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){
//                    TODO：调用登陆接口
                }else{
                    showToast("账号或者密码不能为空");
                }
            }
        });
        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                loginStub.setVisibility(View.GONE);
//                forgetView=forgetStub.inflate();
//                initForget();
            }
        });
    }
    private void initForget(){

    }
    private void showToast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}