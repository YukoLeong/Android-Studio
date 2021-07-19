package com.example.kanon.kanonmoon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by kanon on 1/29/2016.   SQL series can not work
 */
public class SQL_Add extends AppCompatActivity {

    EditText addtext1, addtext2, addtext3;
    Context context = this;
    SQL_UserDbHelper sql_userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_add);
        addtext1 = (EditText) findViewById(R.id.addtext1);
        addtext2 = (EditText) findViewById(R.id.addtext2);
        addtext3 = (EditText) findViewById(R.id.addtext3);
    }

    public void addButton(View view) {
        String name = addtext1.getText().toString();
        String mob = addtext2.getText().toString();
        String email = addtext3.getText().toString();
        sql_userDbHelper = new SQL_UserDbHelper(context);
        sqLiteDatabase = sql_userDbHelper.getWritableDatabase();
        sql_userDbHelper.addInfomations(name, mob, email, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
        sql_userDbHelper.close();

    }
}
