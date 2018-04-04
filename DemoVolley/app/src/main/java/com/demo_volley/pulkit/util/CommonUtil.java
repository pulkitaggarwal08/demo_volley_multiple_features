package com.demo_volley.pulkit.util;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.view.Window;

import com.demo_volley.pulkit.R;

/**
 * Created by pulkit on 16/12/17.
 */

public class CommonUtil {
    private static Dialog dialog;

    public static void showProgressDilaog(Activity activity) {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.progress);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public static void dismissProgressDilaog() {
        dialog.dismiss();
    }

}
