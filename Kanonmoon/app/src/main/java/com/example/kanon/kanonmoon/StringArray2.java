package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kanon on 1/13/2016.
 */
public class StringArray2 extends AppCompatActivity {

    TextView tvquestion, tvanswer, tvpresentindex_xx, tvtotallength_yy;
    Button bleft, bshow, bright;
    String[] qq1, qq2;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.stringarray2);

        tvquestion = (TextView) findViewById(R.id.tvquestion);
        tvanswer = (TextView) findViewById(R.id.tvanswer);
        tvpresentindex_xx = (TextView) findViewById(R.id.tvpresentindex_xx);
        tvtotallength_yy = (TextView) findViewById(R.id.tvtotallength_yy);

        bleft = (Button) findViewById(R.id.bleft);
        bshow = (Button) findViewById(R.id.bshow);
        bright = (Button) findViewById(R.id.bright);

        qq1 = getResources().getStringArray(R.array.qq1);
        qq2 = getResources().getStringArray(R.array.qq2);

        index = 0;
        tvquestion.setText(qq1[index]);
        tvanswer.setText("Press \"Answer\" Button for answer");
        tvpresentindex_xx.setText(String.valueOf(index + 1));           //TextView要string才能顯示
        tvtotallength_yy.setText(String.valueOf(qq1.length));
    }

    public void bleftclick(View view) {
        tvanswer.setText("Press \"Answer\" Button for answer");
        if (index > 0) {
            index--;
            tvquestion.setText(qq1[index]);
            tvpresentindex_xx.setText(String.valueOf(index + 1));

        }
        Log.e("leftmessage", String.valueOf(index));
    }

    public void brightclick(View view) {
        tvanswer.setText("Press \"Answer\" Button for answer");
        if (index < qq1.length - 1) {
            index++;
            tvquestion.setText(qq1[index]);
            tvpresentindex_xx.setText(String.valueOf(index + 1));
        }
        Log.e("rightmessage", String.valueOf(index));
    }

    public void bshowclick(View view) {
        tvanswer.setText(qq2[index]);
    }
}
