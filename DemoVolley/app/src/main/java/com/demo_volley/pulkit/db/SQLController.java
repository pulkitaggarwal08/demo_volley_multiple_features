package com.demo_volley.pulkit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.demo_volley.pulkit.model.MobileActivitiesDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLController {

    private SQLiteDatabase sqLiteDatabase;
    private DataBaseHandler dataBaseHandler;
    private Context context;

    public SQLController(Context context) {
        this.context = context;
        dataBaseHandler = new DataBaseHandler(context);
    }

    public SQLController open() throws SQLException {
        sqLiteDatabase = dataBaseHandler.getWritableDatabase();
        return this;
    }

    public void close() {
        dataBaseHandler.close();
    }

    public void addLocation(String latitudes, String longitudes, String dateTime, String deviceActivity) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHandler.COLUMN_LATITUDES, latitudes);
        contentValues.put(DataBaseHandler.COLUMN_LONGITUDES, longitudes);
        contentValues.put(DataBaseHandler.COLUMN_DATE_TIME, dateTime);
        contentValues.put(DataBaseHandler.COLUMN_DEVICE_ACTIVITY, deviceActivity);
        contentValues.put(DataBaseHandler.COLUMN_STATUS, "0");//0-local db, 1-server

        sqLiteDatabase.insert(DataBaseHandler.TABLE_MOBILE_ACTIVITY, null, contentValues);
    }

    public List<MobileActivitiesDTO> getAllEvents() {
        List<MobileActivitiesDTO> list = new ArrayList<MobileActivitiesDTO>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DataBaseHandler.TABLE_MOBILE_ACTIVITY + " where " + DataBaseHandler.COLUMN_STATUS + " = " + '0', null);

        if (cursor.moveToFirst()) {
            do {
                MobileActivitiesDTO mobileActivitiesDTO = new MobileActivitiesDTO();
                mobileActivitiesDTO.setId(cursor.getInt(0));
                mobileActivitiesDTO.setLatitudes(cursor.getString(1));
                mobileActivitiesDTO.setLongitudes(cursor.getString(2));
                mobileActivitiesDTO.setDateTime(cursor.getString(3));
                mobileActivitiesDTO.setDeviceActivity(cursor.getString(4));
                mobileActivitiesDTO.setStatus(cursor.getString(5));

                list.add(mobileActivitiesDTO);
            }
            while (cursor.moveToNext());
        }
        return list;
    }

    public int updateLocation(String latitudes, String longitudes, String dateTime) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.COLUMN_LATITUDES, latitudes);
        values.put(DataBaseHandler.COLUMN_LONGITUDES, longitudes);
        values.put(DataBaseHandler.COLUMN_DATE_TIME, dateTime);

        // updating row
        return sqLiteDatabase.update(DataBaseHandler.TABLE_MOBILE_ACTIVITY, values,
                DataBaseHandler.COLUMN_LATITUDES + " = ?", new String[]{String.valueOf(latitudes)});
    }


    public Cursor getCursor() {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DataBaseHandler.TABLE_MOBILE_ACTIVITY + " where " + DataBaseHandler.COLUMN_STATUS + " = '0'", null);
        /*if (cursor.moveToFirst()) {
            do {
                MobileActivitiesDTO location = new MobileActivitiesDTO();
                location.setLatitudes(cursor.getString(0));
                location.setLongitudes(cursor.getString(1));
                location.setDateTime(cursor.getString(2));
                location.setDeviceActivity(cursor.getString(3));

                list.add(location);

            }
            while (cursor.moveToNext());
        }*/
        return cursor;
    }

    public void updateRowStatus(List<MobileActivitiesDTO> list) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(DataBaseHandler.COLUMN_STATUS, "1");

                // updating row
                sqLiteDatabase.update(DataBaseHandler.TABLE_MOBILE_ACTIVITY, values,
                        DataBaseHandler.COLUMN_ID + " = " + list.get(i).getId(), null);
            }
        }
    }

    public void deleteUploadedRow() {
        sqLiteDatabase.delete(DataBaseHandler.TABLE_MOBILE_ACTIVITY, DataBaseHandler.COLUMN_STATUS + " = " + '1',
                null);
    }
}
