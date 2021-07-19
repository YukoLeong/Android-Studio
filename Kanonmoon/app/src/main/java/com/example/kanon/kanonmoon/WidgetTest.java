package com.example.kanon.kanonmoon;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Created by kanon on 1/27/2016.
 */
public class WidgetTest extends AppCompatActivity {

    EditText Message;
    SeekBar seekBar;
    float font_size;            //為了儲存用
    String font_color;          //為了儲存用
    String text_info;           //為了儲存用

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgettest);
        Message = (EditText) findViewById(R.id.message);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        //為了儲存用
        SharedPreferences sharedPreferences = WidgetTest.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);
        text_info = sharedPreferences.getString(getString(R.string.TEXT_INFO), "");
        Message.setText(text_info);
        font_size = sharedPreferences.getFloat(getString(R.string.FONT_SIZE), 25);
        font_color = sharedPreferences.getString(getString(R.string.FONT_COLOR), "");
        Message.setTextSize(TypedValue.COMPLEX_UNIT_PX, font_size);
        if (font_size == 25) {
            seekBar.setProgress(0);
        } else {
            seekBar.setProgress((int) font_size);
        }
        if (font_color.equals("RED")) {
            Message.setTextColor(Color.parseColor("#FC0116"));
        } else if (font_color.equals("BLUE")) {
            Message.setTextColor(Color.parseColor("#0810F5"));
        } else if (font_color.equals("GREEN")) {
            Message.setTextColor(Color.parseColor("#03FF20"));
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Message.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress);   //Bar控制字型大小
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                font_size = Message.getTextSize();              //為了儲存用
            }
        });
    }

    public void changeColor(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                Message.setTextColor(Color.parseColor("#FC0116"));              //radio控制字型顏色
                font_color = "RED";                                             //為了儲存用
                break;
            case R.id.rb2:
                Message.setTextColor(Color.parseColor("#0810F5"));
                font_color = "BLUE";
                break;
            case R.id.rb3:
                Message.setTextColor(Color.parseColor("#03FF20"));
                font_color = "GREEN";
                break;
        }
    }

    public void saveSetting(View view) {
        SharedPreferences sharedPreferences = WidgetTest.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(getString(R.string.FONT_SIZE), font_size);
        editor.putString(getString(R.string.FONT_COLOR), font_color);
        editor.putString(getString(R.string.TEXT_INFO), Message.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Your setting has been save!", Toast.LENGTH_SHORT).show();
    }

    public void clearSetting(View view) {
        SharedPreferences sharedPreferences = WidgetTest.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(getApplicationContext(), "Your setting has been clear!", Toast.LENGTH_SHORT).show();
    }
}
