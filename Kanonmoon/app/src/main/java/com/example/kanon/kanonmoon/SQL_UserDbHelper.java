package com.example.kanon.kanonmoon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kanon on 1/29/2016.
 */
public class SQL_UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY = "CREATE TABLE " + SQL_UserContact.NewUserInfo.TABLE_NAME + "(" + SQL_UserContact.NewUserInfo.USER_NAME + " TEXT," + SQL_UserContact.NewUserInfo.USER_MOB + " TEXT," + SQL_UserContact.NewUserInfo.USER_EMAIL + " TEXT);";

    public SQL_UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Table created...");
    }

    public void addInfomations(String name, String mob, String email, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQL_UserContact.NewUserInfo.USER_NAME, name);
        contentValues.put(SQL_UserContact.NewUserInfo.USER_MOB, mob);
        contentValues.put(SQL_UserContact.NewUserInfo.USER_EMAIL, email);
        db.insert(SQL_UserContact.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One row inserted...");
    }

    public Cursor getInformations(SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {SQL_UserContact.NewUserInfo.USER_NAME, SQL_UserContact.NewUserInfo.USER_MOB, SQL_UserContact.NewUserInfo.USER_EMAIL};
        cursor = db.query(SQL_UserContact.NewUserInfo.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
