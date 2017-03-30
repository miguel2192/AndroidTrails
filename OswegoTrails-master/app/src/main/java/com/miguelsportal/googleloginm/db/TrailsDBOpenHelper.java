package com.miguelsportal.googleloginm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by James on 11/27/2016.
 */

public class TrailsDBOpenHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "trails.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_TRAILS = "trails";
    public static final String COLUMN_ID = "trailId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_BIKE = "bike";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_RATING = "rating";

    private static final String TABLE_CREATE = //the SQL code to create DB
            "CREATE TABLE " + TABLE_TRAILS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_DESC + " TEXT, " +
                    COLUMN_IMAGE + " TEXT, " +
                    COLUMN_BIKE + " INTEGER, " +
                    COLUMN_RATING + " INTEGER " +
                    ")";


    public TrailsDBOpenHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {//When SDK is asked to connect to database, if DB doesn't exist onCreate us called
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {//See onCreate, will be called if DB exists but version number is different.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TRAILS);
        onCreate(sqLiteDatabase);
    }
}
