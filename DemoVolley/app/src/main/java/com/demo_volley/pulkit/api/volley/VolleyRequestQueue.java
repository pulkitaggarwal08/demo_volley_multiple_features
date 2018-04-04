package com.demo_volley.pulkit.api.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by pulkit on 16/12/17.
 */

public class VolleyRequestQueue {

    private static RequestQueue queue;

    public static synchronized RequestQueue init(Context context) {
        if (null == queue) {
            queue = Volley.newRequestQueue(context);
        }
        return queue;
    }

}
