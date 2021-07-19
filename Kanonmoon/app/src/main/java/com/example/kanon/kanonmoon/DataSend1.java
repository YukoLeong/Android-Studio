package com.example.kanon.kanonmoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

/**
 * Created by kanon on 1/22/2016.
 */
public class DataSend1 extends AppCompatActivity {

    public final static String MESSAGE_KEY = "com.example.kanon.kanonmoon";
    EditText editText;
    AutoCompleteTextView AutoCompleteTextView;
    String[] country_Names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datasend1);
        AutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoTextView);
        country_Names = getResources().getStringArray(R.array.country_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,country_Names);
        AutoCompleteTextView.setAdapter(adapter);
    }

    public void sendMessage(View view) {
        editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        Intent intent = new Intent(this, DataSend2.class);
        intent.putExtra(MESSAGE_KEY, message);
        startActivity(intent);
    }
}
