package com.uukeshov.point;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by uukeshov on 3/17/2016.
 */
class PointDB extends SQLiteOpenHelper {

    private static final String LOG_TAG = "PointDbLog";

    public PointDB(Context context) {
        super(context, "PointDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pointstable (id integer primary key autoincrement,pointid text, pointname text,pointLat text,pointLon text);");
    }

    public void addPoint(Point point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("pointid", point.get_pointName());
        cv.put("pointname", point.get_pointName());
        cv.put("pointLat", point.get_pointLat());
        cv.put("pointLon", point.get_pointLon());
        db.insert("pointstable", null, cv);
        db.close();
    }

    public List<Point> getAllPoints() {

        List<Point> noteList = new ArrayList<Point>();
        String selectQuery = "SELECT * FROM pointstable ORDER BY id DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Point point = new Point();
                point.set_pointID(Integer.valueOf(cursor.getString(0)));
                point.set_pointName(cursor.getString(1));
                point.set_pointName(cursor.getString(2));
                point.set_pointLat(cursor.getDouble(3));
                point.set_pointLon(cursor.getDouble(4));
                noteList.add(point);
          //      Log.d(LOG_TAG, "--- onCreate database ---" + note);
            } while (cursor.moveToNext());
        }
        db.close();
        return noteList;
    }

    public void deleteAllPoints() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + "pointstable");
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}