package com.example.lostandfound.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lostandfound.DataClasses.Advert;

import java.util.ArrayList;
import java.util.List;

public class AdvertDatabaseHelper extends SQLiteOpenHelper {



    public static final String DATABASE_NAME = "advert_database";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_ADVERTS = "adverts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_POST_TYPE = "post_type";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_LOCATION = "location";

    public static final String CREATE_TABLE_ADVERTS = "CREATE TABLE " + TABLE_ADVERTS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_POST_TYPE + " TEXT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_PHONE_NUMBER + " TEXT," +
            COLUMN_DESCRIPTION + " TEXT," +
            COLUMN_DATE + " TEXT," +
            COLUMN_LOCATION + " TEXT" +
            ")";

    public AdvertDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ADVERTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement database upgrade if needed
    }

    public long saveAdvert(Advert advert) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_POST_TYPE, advert.getPostType());
        values.put(COLUMN_NAME, advert.getName());
        values.put(COLUMN_PHONE_NUMBER, advert.getPhoneNumber());
        values.put(COLUMN_DESCRIPTION, advert.getDescription());
        values.put(COLUMN_DATE, advert.getDate());
        values.put(COLUMN_LOCATION, advert.getLocation());
        long id = db.insert(TABLE_ADVERTS, null, values);
//        db.close();
        return id;
    }

    public List<Advert> getAllAdverts() {
        List<Advert> adverts = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ADVERTS, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String postType = cursor.getString(cursor.getColumnIndex(COLUMN_POST_TYPE));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String phoneNumber = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE_NUMBER));
                String description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
                String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                String location = cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION));

                Advert advert = new Advert(id, postType, name, phoneNumber, description, date, location);
                adverts.add(advert);
            } while (cursor.moveToNext());
        }
        cursor.close();
//        db.close();
        return adverts;
    }
}

