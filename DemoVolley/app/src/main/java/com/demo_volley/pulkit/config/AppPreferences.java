package com.demo_volley.pulkit.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by pulkit on 16/12/17.
 */

public class AppPreferences {

    private static AppPreferences appPreferences;
    protected SharedPreferences sharedPreferences;

    public AppPreferences(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static AppPreferences init(Context context) {
        if (null == appPreferences) {
            appPreferences = new AppPreferences(context);
        }
        return appPreferences;
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getSavedString(String key, String value) {
        return sharedPreferences.getString(key, value);
    }

}
