package com.example.kanon.kanonmoon;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.w3c.dom.UserDataHandler;

import java.util.List;

/**
 * Created by kanon on 2/1/2016.
 */
public class SQL_ListView extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    SQL_UserDbHelper sql_userDbHelper;
    Cursor cursor;
    SQL_ListDataAdapter sql_listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_listview);
        listView = (ListView) findViewById(R.id.listView);
        sql_listDataAdapter = new SQL_ListDataAdapter(getApplicationContext(), R.layout.sql_rowlayout);
        listView.setAdapter(sql_listDataAdapter);

        sql_userDbHelper = new SQL_UserDbHelper(getApplicationContext());
        sqLiteDatabase = sql_userDbHelper.getReadableDatabase();
        cursor = sql_userDbHelper.getInformations(sqLiteDatabase);
        if (cursor.moveToFirst()) {
            do {
                String name, mob, email;
                name = cursor.getString(0);
                mob = cursor.getString(1);
                email = cursor.getString(2);
                SQL_DataProvider sql_dataProvider = new SQL_DataProvider(name,mob,email);
                sql_listDataAdapter.add(sql_dataProvider);

            } while (cursor.moveToNext());
        }
    }
}
