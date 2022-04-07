package com.lzhihua.bycar.commonui;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.lzhihua.bycar.R;

public class PopupDialog {
    protected Context context;
    protected Dialog mDialog;
    protected View mView;
    //0为默认 0.8 高度，1为自适应高度
    public PopupDialog(Context context,int resId,int heightType){
        this.context=context;
        LayoutInflater inflater=LayoutInflater.from(context);
        mView=inflater.inflate(resId,null);
        mDialog=new Dialog(context, R.style.dialog);
        mDialog.setContentView(mView);

        Window dialogWindow=mDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogWindowAnim);
        WindowManager.LayoutParams lp=dialogWindow.getAttributes();
        lp.width=context.getResources().getDisplayMetrics().widthPixels;
        int height=0;
        if(heightType==0){
            height= (int) (context.getResources().getDisplayMetrics().heightPixels*0.8);
        }else{
            height=WindowManager.LayoutParams.WRAP_CONTENT;
        }
        lp.height=height;
        dialogWindow.setAttributes(lp);

    }
    public void show(){
        mDialog.show();
    }
    public void dismiss(){
        mDialog.dismiss();
    }
}
