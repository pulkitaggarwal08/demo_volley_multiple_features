package com.demo_volley.pulkit.util;

import android.app.Activity;
import android.support.design.widget.Snackbar;

import com.demo_volley.pulkit.R;
import com.demo_volley.pulkit.config.App;

/**
 * Created by pulkit on 16/12/17.
 */

public class SnackbarUtil {

    public static void showSuccessLongSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(App.getInstance().getResources().getColor(R.color.white));
//        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
//        params.gravity = Gravity.TOP;
        snackbar.show();
    }

    public static void showSuccessShortSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(App.getInstance().getResources().getColor(R.color.white));
        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        //params.gravity = Gravity.TOP;
        snackbar.show();
    }

    public static void showErrorLongSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(App.getInstance().getResources().getColor(R.color.white));
        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        //params.gravity = Gravity.TOP;
        snackbar.show();
    }

    public static void showErrorShortSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(App.getInstance().getResources().getColor(R.color.white));
        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        //params.gravity = Gravity.TOP;
        snackbar.show();
    }

    public static void showWarningLongSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(App.getInstance().getResources().getColor(R.color.white));
        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        //params.gravity = Gravity.TOP;
        snackbar.show();
    }

    public static void showWarningShortSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, 800);
        snackbar.getView().setBackgroundColor(App.getInstance().getResources().getColor(R.color.white));
        // FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbar.getView().getLayoutParams();
        //params.gravity = Gravity.TOP;
        snackbar.show();
    }

}
