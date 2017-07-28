package com.zyn.expressinquiry.mvp.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zyn.expressinquiry.R;

/**
 * Desc:
 * CreateDate: 2017/7/27 23:25
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class LoadingDialog {
    public static Dialog getLoadingDialog(Context context, String msg){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);

        tipTextView.setText(msg);

        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);

        loadingDialog.setCancelable(false);//不可取消

        //设置布局
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return loadingDialog;
    }
}
