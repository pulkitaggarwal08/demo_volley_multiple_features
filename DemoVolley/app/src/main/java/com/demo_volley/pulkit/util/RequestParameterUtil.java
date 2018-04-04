package com.demo_volley.pulkit.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pulkit on 16/12/17.
 */

public class RequestParameterUtil {

    public static JSONObject prepareLoginObject(String email, String password, String deviceId, String imeiNumber,
                                                String deviceModelNumber, String deviceOsVersion, String deviceAppVersion,
                                                String batteryLevel, String appType, String dateTimeFormat, String activity,
                                                String latitude, String longitude, String deviceType,
                                                String connectionType) {

        JSONObject resultObject = new JSONObject();
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", email);
            jsonObject.put("password", password);
            jsonObject.put("activity", activity);
            jsonObject.put("device_type", deviceType);
            jsonObject.put("latitude", latitude);
            jsonObject.put("longitude", longitude);
            jsonObject.put("app_type", appType);
            jsonObject.put("device_id", deviceId);
            jsonObject.put("device_imei_no", imeiNumber);
            jsonObject.put("device_model_no", deviceModelNumber);
            jsonObject.put("device_os_version", deviceOsVersion);
            jsonObject.put("battery", batteryLevel);
            jsonObject.put("app_version", deviceAppVersion);
            jsonObject.put("device_date_time", dateTimeFormat);
            //MOBILE_DATA, WIFI
            jsonObject.put("internet_connection_type", connectionType);

            resultObject.put("data", jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return resultObject;
    }

}
