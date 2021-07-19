package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kanon on 1/11/2016.
 */
public class ReadFile02 extends AppCompatActivity {

    public EditText editText;
    public TextView textView;
    public Button save, load;

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/kanonaa";

    String[] testarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readfile02);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        save = (Button) findViewById(R.id.save);
        load = (Button) findViewById(R.id.load);

        File dir = new File(path);
        dir.mkdirs();
    }

    public void buttonSave(View view) {
        File file = new File(path + "/savedFile.txt");
        String[] saveText = String.valueOf(editText.getText()).split(System.getProperty("line.separator"));
        editText.setText("");
        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        Save(file, saveText);
    }

    public void buttonLoad(View view) {
        File file = new File(path + "/savedFile.txt");
        String[] loadText = Load(file);
        String finalString = "";
        testarray = new String[loadText.length];            //測試能否放進新的array
        for (int i = 0; i < loadText.length; i++) {
            finalString += loadText[i] + System.getProperty("line.separator");
            testarray[i] = loadText[i];
            Log.e("message " + i + " :", loadText[i]);      //一般沒問題的話直接用loadText[]這個array就好
            Log.e("testmessage " + i + " :", testarray[i]);
        }
        textView.setText(finalString);
    }

    public static void Save(File file, String[] data) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                for (int i = 0; i < data.length; i++) {
                    fos.write(data[i].getBytes());
                    if (i < data.length - 1) {
                        fos.write("\n".getBytes());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] Load(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String test;
        int anzahl = 0;

        try {
            while ((test = br.readLine()) != null) {
                anzahl++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.getChannel().position(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] array = new String[anzahl];
        String line;
        int i = 0;
        try {
            while ((line = br.readLine()) != null) {
                array[i] = line;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}
