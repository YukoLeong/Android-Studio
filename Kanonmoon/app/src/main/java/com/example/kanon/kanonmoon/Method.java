package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kanon on 9/29/2015.
 */
public class Method extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.method_layout);

        Button button5 = (Button) findViewById(R.id.button5);
        final TextView textView = (TextView) findViewById(R.id.textView);

        button5.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        textView.setText("changeText");
                    }
                }
        );

        button5.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        textView.setText("that was a long one!");
                        return true;    //false的時候只會暫時變字 true才會永久改變
                    }
                }
        );
    }
}
