package com.demo_volley.pulkit.config;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.demo_volley.pulkit.api.volley.VolleyRequestQueue;

/**
 * Created by pulkit on 16/12/17.
 */

public class App extends Application {

    private static App instance;
    private static AppPreferences appPreferences;
    private static RequestQueue requestQueue;

    public static AppPreferences getAppPreferences(){
        return  appPreferences;
    }

    public static App getInstance(){
        return instance;
    }

    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        appPreferences = AppPreferences.init(instance);
        requestQueue = VolleyRequestQueue.init(instance);
    }
}
