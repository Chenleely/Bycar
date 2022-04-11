package com.lzhihua.bycar.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.TranslateAnimation;

public class UITools {
    public static int dip2px(Context context,float dpValue){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int) (dpValue*scale+0.5f);
    }


}
