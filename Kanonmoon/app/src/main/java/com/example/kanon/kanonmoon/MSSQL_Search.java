package com.example.kanon.kanonmoon;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/***********
 * 成功連結數據庫 注意要把jtds-1.2.7.jar放在app->libs裡面
 **************/

public class MSSQL_Search extends ActionBarActivity {
    TextView lblheader;
    Typeface font;
    Button btnviewall, btnview;
    ListView lstcountry;
    EditText edtid;

    String usernameS;
    String datets;
    String call = "172.25.2.59", db = "V63MPI0114test", un = "sa", passwords = "ehr2013";
    // CONN(un = _user, passwords = _pass, db = _DB, call = _server)
    Connection connect;
    ResultSet rs;

    @SuppressLint("NewApi")
    private Connection CONN(String _user, String _pass, String _DB,
                            String _server) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://" + _server + ";"
                    + "databaseName=" + _DB + ";user=" + _user + ";password="
                    + _pass + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mssql_search);
        lblheader = (TextView) findViewById(R.id.lblheader);
        lstcountry = (ListView) findViewById(R.id.lstcountry);
        btnviewall = (Button) findViewById(R.id.btnviewall);
        btnview = (Button) findViewById(R.id.btnview);
        edtid = (EditText) findViewById(R.id.edtid);
        /************* CONNECTION DATABASE VARIABLES ***************/
        connect = CONN(un, passwords, db, call);
        btnviewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PreparedStatement statement = connect.prepareStatement("EXEC viewAllCountries");
                    final ArrayList list = new ArrayList();
                    rs = statement.executeQuery();
                    while (rs.next()) {
                        list.add(rs.getString("CountryName"));
                    }
                    ArrayAdapter adapter = new ArrayAdapter(MSSQL_Search.this,
                            android.R.layout.simple_list_item_1, list);
                    lstcountry.setAdapter(adapter);
                } catch (SQLException e) {
                    Toast.makeText(MSSQL_Search.this, e.getMessage().toString(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PreparedStatement statement = connect.prepareStatement("EXEC viewCountry '" + edtid.getText().toString() + "'");
                    final ArrayList list = new ArrayList();
                    rs = statement.executeQuery();
                    while (rs.next()) {
                        list.add(rs.getString("CountryName"));
                    }
                    ArrayAdapter adapter = new ArrayAdapter(MSSQL_Search.this,
                            android.R.layout.simple_list_item_1, list);
                    lstcountry.setAdapter(adapter);
                } catch (SQLException e) {
                    Toast.makeText(MSSQL_Search.this, e.getMessage().toString(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        lstcountry.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String item = lstcountry.getItemAtPosition(position).toString();
                Toast.makeText(MSSQL_Search.this, item + " selected", Toast.LENGTH_LONG).show();
            }
        });
    }
}
