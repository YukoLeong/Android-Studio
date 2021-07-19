package com.example.kanon.kanonmoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kanon on 1/22/2016.
 */
public class DataSend2 extends AppCompatActivity {

    public final static String MESSAGE_KEY = "com.example.kanon.kanonmoon";
    TextView showView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datasend2);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MESSAGE_KEY);
        showView = (TextView) findViewById(R.id.showView);
        showView.setText(message);
    }
}
