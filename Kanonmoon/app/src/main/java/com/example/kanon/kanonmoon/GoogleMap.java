package com.example.kanon.kanonmoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.kanon.kanonmoon.GoogleMap;


/**
 * Created by kanon on 2/11/2016.
 */
public class GoogleMap extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent("com.example.kanon.googlemap");
        startActivity(intent);
    }
}
