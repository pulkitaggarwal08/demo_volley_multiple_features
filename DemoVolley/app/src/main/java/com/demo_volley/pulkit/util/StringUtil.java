package com.demo_volley.pulkit.util;

/**
 * Created by pulkit on 16/12/17.
 */

public class StringUtil {
    public static boolean isEmpty(String data) {
        if (data.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
