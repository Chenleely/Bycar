package com.lzhihua.bycar.ui.dialog;

import android.content.Context;
import android.os.HandlerThread;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.bean.CityList;
import com.lzhihua.bycar.commonui.PopupDialog;
import com.lzhihua.bycar.databinding.ChooseCarDialogBinding;
import com.lzhihua.bycar.network.DataSuccessListenter;
import com.lzhihua.bycar.repo.CityRepo;

import java.util.logging.Handler;

public class ChooseCarDialog extends PopupDialog {
    private ChooseCarDialogBinding chooseCarDialogBinding;

    public ChooseCarDialog(Context context){
        this(context, R.layout.choose_car_dialog,0);
    }
    public ChooseCarDialog(Context context, int resId, int heightType) {
        super(context, resId, 0);
    }

}
