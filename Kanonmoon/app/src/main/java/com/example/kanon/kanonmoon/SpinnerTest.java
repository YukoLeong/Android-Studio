package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by kanon on 1/25/2016.
 */
public class SpinnerTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnertest);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //建立一個ArrayAdapter物件，並放置下拉選單的內容
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,new String[]{"紅茶","奶茶","綠茶"});
        //設定下拉選單的樣式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //設定項目被選取之後的動作
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "您選擇" + adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(getApplicationContext(), "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }
        });
    }
}
