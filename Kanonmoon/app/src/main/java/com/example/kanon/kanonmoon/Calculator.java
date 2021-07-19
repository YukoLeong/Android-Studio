package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kanon on 1/11/2016.
 */
public class Calculator extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    Button addButton;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        firstNumber = (EditText) findViewById(R.id.firstNumber);
        secondNumber = (EditText) findViewById(R.id.secondNumber);
        addButton = (Button) findViewById(R.id.btnAdd);
        total = (TextView) findViewById(R.id.total);

    }

    public void btnAdd_Click(View view) {
        String firstNumberResult = firstNumber.getText().toString();
        String secondNumberResult = secondNumber.getText().toString();
        Integer totalResult = Integer.parseInt(firstNumberResult) + Integer.parseInt(secondNumberResult);
        total.setText("Total = " + Integer.toString(totalResult));

    }
}
