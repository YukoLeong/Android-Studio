package com.example.kanon.kanonmoon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
/**
 *    http://www.parallelcodes.com/android-retrieving-images-stored-in-base64-value-from-ms-sql-server/
 */
public class MSSQL_ShowImage extends ActionBarActivity {
    public static final int requestcode = 1;
    ImageView img;
    TextView lblpath;
    Dialog m;
    EditText edtid;
    Button btnfetch;
    ProgressBar pbbar;
    byte[] byteArray;
    String call, db, un, passwords;
    String id;
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
                    + _pass + ";"; // c: // :c
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
        setContentView(R.layout.mssql_showimage);
        img = (ImageView) findViewById(R.id.imageview);
        lblpath = (TextView) findViewById(R.id.lblpath);
        edtid = (EditText) findViewById(R.id.edtid);
        btnfetch = (Button) findViewById(R.id.btnfetch);
        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);
        call = "172.25.2.59";
        un = "sa";
        passwords = "ehr2013";
        db = "V63MPI0114test";
        btnfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = edtid.getText().toString();
                Fetch f = new Fetch();
                f.execute("");
            }
        });
    }
    private class Fetch extends AsyncTask<String, String, String> {
        String z = " ";

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            String query = "select * from kanonimage where ID=" + id;
            try {
                connect = CONN(un, passwords, db, call);
                Statement stmt = connect.createStatement();
                rs = stmt.executeQuery(query);
                if (rs != null && rs.next()) {
                    z = rs.getString("Img");    //column name
                }
            } catch (Exception e) {
                System.out.print("err");
                e.printStackTrace();
                z = "No such ID";
            }
            return z;
        }

        @Override
        protected void onPostExecute(String rs) {
            byte[] decodeString = Base64.decode(rs, Base64.DEFAULT);
            Bitmap decodebitmap = BitmapFactory.decodeByteArray(decodeString,
                    0, decodeString.length);
            img.setImageBitmap(decodebitmap);
            pbbar.setVisibility(View.GONE);
        }
    }
}