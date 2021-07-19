package com.example.kanon.englishwordtest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView engword1, engword2, engword3, wordxx, wordyy;
    Button buttonleft, buttonright, buttonshow;
    String[] loadText1, loadText2, loadText3;
    int[] ramdomstore;
    int index;

    // 突然又讀不到了 16/07/16
    // java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String java.io.BufferedReader.readLine()' on a null object reference
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LearnEnglish";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        engword1 = (TextView) findViewById(R.id.engword1);
        engword2 = (TextView) findViewById(R.id.engword2);
        engword3 = (TextView) findViewById(R.id.engword3);
        wordxx = (TextView) findViewById(R.id.wordxx);
        wordyy = (TextView) findViewById(R.id.wordyy);

        buttonleft = (Button) findViewById(R.id.buttonleft);
        buttonright = (Button) findViewById(R.id.buttonright);
        buttonshow = (Button) findViewById(R.id.buttonshow);

        File dir = new File(path);
        dir.mkdirs();

        //load file
        File file1 = new File(path + "/eng1.txt");
        loadText1 = Load(file1);
        File file2 = new File(path + "/eng2.txt");
        loadText2 = Load(file2);
        File file3 = new File(path + "/eng3.txt");
        loadText3 = Load(file3);

        //random
        int n = loadText1.length;
        Random random = new Random();
        List<Integer> list = new ArrayList<Integer>();
        ramdomstore = new int[loadText1.length];
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        for (int i = 0; i < n; i++) {
            int temp = random.nextInt(n - i) + 1;
            ramdomstore[i] = (list.get(temp - 1)) - 1;
//            Log.e("random_message: ", i + ": " + String.valueOf(ramdomstore[i]));
//            System.out.print(list.get(temp - 1) + " ");
            list.remove(temp - 1);
        }

        index = 0;
        engword1.setText(loadText1[ramdomstore[index]]);
        engword2.setText("Press \"Answer\" Button for answer");
        wordxx.setText(String.valueOf(index + 1));
        wordyy.setText(String.valueOf(loadText1.length));
    }

    public void leftclick(View view) {
        if (index > 0) {
            engword2.setText("Press \"Answer\" Button for answer");
            engword3.setText("");

            index--;
            engword1.setText(loadText1[ramdomstore[index]]);
            wordxx.setText(String.valueOf(index + 1));
        }
//        Log.e("leftmessage", String.valueOf(index));
    }

    public void rightclick(View view) {
        if (index < loadText1.length - 1) {
            engword2.setText("Press \"Answer\" Button for answer");
            engword3.setText("");

            index++;
            engword1.setText(loadText1[ramdomstore[index]]);
            wordxx.setText(String.valueOf(index + 1));
        }
//        Log.e("rightmessage", String.valueOf(index));
    }

    public void showclick(View view) {
        engword2.setText(loadText2[ramdomstore[index]]);
        engword3.setText(loadText3[ramdomstore[index]]);
    }

    public static String[] Load(File file) {
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in, "unicode"));
        } catch (Exception e) {
            e.printStackTrace();
        }

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

