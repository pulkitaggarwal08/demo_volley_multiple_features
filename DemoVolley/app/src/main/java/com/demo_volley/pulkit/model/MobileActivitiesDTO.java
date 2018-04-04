package com.demo_volley.pulkit.model;

/**
 * Created by pulkit on 16/12/17.
 */

public class MobileActivitiesDTO {
    private int id;
    private String latitudes;
    private String longitudes;
    private String dateTime;
    private String deviceActivity;
    private String status;

    public String getLatitudes() {
        return latitudes;
    }

    public void setLatitudes(String latitudes) {
        this.latitudes = latitudes;
    }

    public String getLongitudes() {
        return longitudes;
    }

    public void setLongitudes(String longitudes) {
        this.longitudes = longitudes;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDeviceActivity() {
        return deviceActivity;
    }

    public void setDeviceActivity(String deviceActivity) {
        this.deviceActivity = deviceActivity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}