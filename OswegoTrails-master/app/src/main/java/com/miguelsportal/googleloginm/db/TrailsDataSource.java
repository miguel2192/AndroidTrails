package com.miguelsportal.googleloginm.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.miguelsportal.googleloginm.Trail;

import java.util.ArrayList;
import java.util.List;

import static com.google.ads.AdRequest.LOGTAG;


/**
 * Created by James on 11/27/2016.
 */

public class TrailsDataSource
{

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    public static final String LOGTAG="TRAILDATASOURCE";


    private static final String[] allColumns =
            {
                    TrailsDBOpenHelper.COLUMN_ID,
                    TrailsDBOpenHelper.COLUMN_NAME,
                    TrailsDBOpenHelper.COLUMN_DESC,
                    TrailsDBOpenHelper.COLUMN_BIKE,
                    TrailsDBOpenHelper.COLUMN_IMAGE,
               //     TrailsDBOpenHelper.COLUMN_RATING
            };

    public TrailsDataSource(Context context)
    {
        dbhelper = new TrailsDBOpenHelper(context);
    }

    public void open()
    {
        Log.i(LOGTAG, "Database opened");
        database = dbhelper.getWritableDatabase();
    }

    public void close()
    {
        dbhelper.close();
    }

    public Trail create(Trail trail)
    {
        ContentValues values = new ContentValues();
        values.put(TrailsDBOpenHelper.COLUMN_NAME, trail.getName());
        values.put(TrailsDBOpenHelper.COLUMN_DESC, trail.getDescription());
        values.put(TrailsDBOpenHelper.COLUMN_BIKE, trail.getBike());
        values.put(TrailsDBOpenHelper.COLUMN_IMAGE, trail.getImage());
       // values.put(TrailsDBOpenHelper.COLUMN_RATING, trail.getRating());
        long insertid = database.insert(TrailsDBOpenHelper.TABLE_TRAILS, null, values);
        trail.setTrailID(insertid);
        return trail;
    }

    public List<Trail> searchName(String query)
    {
        String sql = " SELECT * FROM " + TrailsDBOpenHelper.TABLE_TRAILS + " WHERE " + TrailsDBOpenHelper.COLUMN_NAME + " LIKE '%"+query+"%'";
        Cursor cursor = database.rawQuery(sql, null);
        List<Trail> trails = cursorToList(cursor);
        return trails;
    }

    public List<Trail> findAll()
    {

        Cursor cursor = database.query(TrailsDBOpenHelper.TABLE_TRAILS, allColumns, null, null, null, null, null);
        List<Trail> trails = cursorToList(cursor);
        return trails;
    }

    public List<Trail> findFiltered(String selection, String orderby)
    {

        Cursor cursor = database.query(TrailsDBOpenHelper.TABLE_TRAILS, allColumns, selection, null, null, null, orderby);
        List<Trail> trails = cursorToList(cursor);
        return trails;
    }


    @NonNull
    private List<Trail> cursorToList(Cursor cursor) {
        List<Trail> trails = new ArrayList<Trail>();
        if (cursor.getCount() > 0)
        {
            while(cursor.moveToNext())
            {
                Trail trail = new Trail();
                trail.setTrailID(cursor.getLong(cursor.getColumnIndex(TrailsDBOpenHelper.COLUMN_ID)));
                trail.setName(cursor.getString(cursor.getColumnIndex(TrailsDBOpenHelper.COLUMN_NAME)));
                trail.setDescription(cursor.getString(cursor.getColumnIndex(TrailsDBOpenHelper.COLUMN_DESC)));
                trail.setBike(cursor.getInt(cursor.getColumnIndex(TrailsDBOpenHelper.COLUMN_BIKE)));
                trail.setImage(cursor.getString(cursor.getColumnIndex(TrailsDBOpenHelper.COLUMN_IMAGE)));
                //trail.setRating(cursor.getInt(cursor.getColumnIndex(TrailsDBOpenHelper.COLUMN_RATING)));
                trails.add(trail);
            }
        }
        return trails;
    }
}
