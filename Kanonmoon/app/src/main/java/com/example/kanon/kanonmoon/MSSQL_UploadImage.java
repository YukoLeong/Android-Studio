package com.example.kanon.kanonmoon;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.AndroidRuntimeException;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 *        http://www.parallelcodes.com/android-storing-images-in-ms-sql-server/
 */
public class MSSQL_UploadImage extends ActionBarActivity {
    public static final int requestcode = 1;
    ImageView img;
    Button btnupload, btnchooseimage;
    EditText edtname;
    byte[] byteArray;
    String encodedImage;
    TextView txtmsg;
    ProgressBar pg;
    ResultSet rs;
    Connection con;
    String un;
    String password;
    String db;
    String ip;
    @SuppressLint("NewApi")
    private Connection ConnectionHelper(String user, String password,
                                        String database, String server) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + server + ";"
                    + "databaseName=" + database + ";user=" + user
                    + ";password=" + password + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return connection;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mssql_uploadimage);
        img = (ImageView) findViewById(R.id.imageview);
        btnupload = (Button) findViewById(R.id.btnupload);
        btnchooseimage = (Button) findViewById(R.id.btnchooseimage);
        edtname = (EditText) findViewById(R.id.edtname);
        txtmsg = (TextView) findViewById(R.id.txtmsg);
        pg = (ProgressBar) findViewById(R.id.progressBar1);
        pg.setVisibility(View.GONE);
        un = "sa";
        password = "ehr2013";
        db = "V63MPI0114test";
        ip = "172.25.2.59";
        con = ConnectionHelper(un, password, db, ip);
        btnchooseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseImage();
            }
        });
        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadtoDB();
            }
        });
    }
    public void UploadtoDB() {
        String msg = "Uploading, Please wait!";
        Toast.makeText(getApplicationContext(), "Uploading, Please wait!", Toast.LENGTH_SHORT).show();
        try {
            con = ConnectionHelper(un, password, db, ip);
            String commands = "Insert into kanonimage (ImgName,Img) values ('"
                    + edtname.getText().toString() + "','" + encodedImage
                    + "')";
            // encodedImage which is the Base64 String
            PreparedStatement preStmt = con.prepareStatement(commands);

            preStmt.executeUpdate();
            msg = "Inserted Successfully";
            Toast.makeText(getApplicationContext(), "Your Image has been uploaded!", Toast.LENGTH_SHORT).show();
        } catch (SQLException ex) {
            msg = ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (IOError ex) {
            // TODO: handle exception
            msg = ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (AndroidRuntimeException ex) {
            msg = ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (NullPointerException ex) {
            msg = ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
        catch (Exception ex) {
            msg = ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
        txtmsg.setText(msg);
    }

    public void ChooseImage() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)
                && !Environment.getExternalStorageState().equals(
                Environment.MEDIA_CHECKING)) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 1);
        } else {
            Toast.makeText(MSSQL_UploadImage.this,
                    "No activity found to perform this task",
                    Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bitmap originBitmap = null;
            Uri selectedImage = data.getData();
//            Toast.makeText(MSSQL_UploadImage.this, selectedImage.toString(),
//                    Toast.LENGTH_LONG).show();
            txtmsg.setText(selectedImage.toString());
            InputStream imageStream;
            try {
                imageStream = getContentResolver().openInputStream(
                        selectedImage);
                originBitmap = BitmapFactory.decodeStream(imageStream);
            } catch (FileNotFoundException e) {
                txtmsg.setText(e.getMessage().toString());
            }
            if (originBitmap != null) {
                this.img.setImageBitmap(originBitmap);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                originBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray();
                encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
//                Toast.makeText(MSSQL_UploadImage.this, "Conversion Done",
//                        Toast.LENGTH_SHORT).show();
            }
        } else {
            txtmsg.setText("There's an error if this code doesn't work, thats all I know");
        }
    }
}

