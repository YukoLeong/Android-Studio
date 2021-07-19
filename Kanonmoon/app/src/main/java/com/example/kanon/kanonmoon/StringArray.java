package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by kanon on 1/13/2016.
 */
public class StringArray extends AppCompatActivity {

    public TextView show1, show2, show3, show4, show5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringarray);

        show1 = (TextView) findViewById(R.id.show1);
        show2 = (TextView) findViewById(R.id.show2);
        show3 = (TextView) findViewById(R.id.show3);
        show4 = (TextView) findViewById(R.id.show4);
        show5 = (TextView) findViewById(R.id.show5);

        String[] my_string = getResources().getStringArray(R.array.arraytest01);
        show1.setText(my_string[0]);
        show2.setText(my_string[1]);
        show3.setText(my_string[2]);
        show4.setText(my_string[3]);
        show5.setText(my_string[4]);
    }
}
