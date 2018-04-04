package com.demo_volley.pulkit.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.demo_volley.pulkit.config.App;

/**
 * Created by pulkit on 16/12/17.
 */

public class ConnectivityReceiver extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityReceiverListener;
    public static NetworkInfo activeNetwork;
    public static String networkType;

    public ConnectivityReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (isConnected()) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                networkType = "WIFI_ON";
                Toast.makeText(context, "WIFI_ON", Toast.LENGTH_SHORT).show();

            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                networkType = "GPRS_ON";
                Toast.makeText(context, "GPRS_ON", Toast.LENGTH_SHORT).show();

            } else {
                networkType = "WIFI_OFF";
                Toast.makeText(context, "WIFI_OFF", Toast.LENGTH_SHORT).show();
            }
        } else {
            networkType = "WIFI_OFF";
            Toast.makeText(context, "WIFI_OFF", Toast.LENGTH_SHORT).show();
        }

        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected());
        }
    }

    public static boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }

}
