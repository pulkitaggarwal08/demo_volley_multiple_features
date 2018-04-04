package com.demo_volley.pulkit.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pulkit on 16/12/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_MOBILE_ACTIVITY = "mobile_activity";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MOBILE_ACTIVITY = "mobileactivity";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LATITUDES = "latitudes";
    public static final String COLUMN_LONGITUDES = "longitudes";
    public static final String COLUMN_DATE_TIME = "date_time";
    public static final String COLUMN_DEVICE_ACTIVITY = "device_activity";
    public static final String COLUMN_STATUS = "status";

    private static final String CREATE_TABLE_LATLNG = "CREATE TABLE " + TABLE_MOBILE_ACTIVITY + "(" +
            COLUMN_ID + " integer primary key autoincrement," +
            COLUMN_LATITUDES + " TEXT," +
            COLUMN_LONGITUDES + " TEXT," +
            COLUMN_DATE_TIME + " TEXT," +
            COLUMN_DEVICE_ACTIVITY + " TEXT," +
            COLUMN_STATUS + " TEXT);";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_MOBILE_ACTIVITY, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LATLNG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOBILE_ACTIVITY);
        onCreate(db);
    }

}
