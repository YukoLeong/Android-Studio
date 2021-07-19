package com.example.kanon.kanonmoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by kanon on 1/29/2016.
 */
public class SQL_Home extends AppCompatActivity {


    Button sqlbutton1, sqlbutton2, sqlbutton3, sqlbutton4, sqlbutton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_home);

        sqlbutton1 = (Button) findViewById(R.id.sqlbutton1);
        sqlbutton2 = (Button) findViewById(R.id.sqlbutton2);
        sqlbutton3 = (Button) findViewById(R.id.sqlbutton3);
        sqlbutton4 = (Button) findViewById(R.id.sqlbutton4);
        sqlbutton5 = (Button) findViewById(R.id.sqlbutton5);

        sqlbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openindex = new Intent("android.intent.action.AS24");
                startActivity(openindex);
            }
        });
    }

    public void addContact(View view) {
        Intent intent = new Intent(this, SQL_UserContact.NewUserInfo.class);
        startActivity(intent);
    }

    public void viewContact(View view) {
        Intent intent = new Intent(this, SQL_ListView.class);
        startActivity(intent);
    }

}
