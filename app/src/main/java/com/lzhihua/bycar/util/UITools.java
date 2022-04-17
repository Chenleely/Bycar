package com.lzhihua.bycar.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.lzhihua.bycar.R;

public class UITools {
    private  static float density = Resources.getSystem().getDisplayMetrics().density;
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static float px2dp(float pxValue) {
        return (pxValue / Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        return (int) (0.5f + dpValue * density);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static float px2dip(float pxValue) {
        return (pxValue / density);
    }

    public static void  showToast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    public static Drawable getDrawable(Resources resources,final String id){
        Drawable drawable;
        switch (id){
            case "ec6":
                drawable=resources.getDrawable(R.drawable.ec6);
                break;
            case "es6":
                drawable=resources.getDrawable(R.drawable.es6);
                break;
            case "es8":
                drawable=resources.getDrawable(R.drawable.es8);
                break;
            case "et5":
                drawable=resources.getDrawable(R.drawable.et5);
                break;
            case "et7":
                drawable=resources.getDrawable(R.drawable.et7);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        return drawable;
    }
}
