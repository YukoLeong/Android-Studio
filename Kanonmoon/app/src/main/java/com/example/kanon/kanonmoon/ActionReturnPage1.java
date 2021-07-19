package com.example.kanon.kanonmoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by kanon on 2/4/2016.
 */
public class ActionReturnPage1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionreturnpage1);
    }

    public void goTwoPage(View view) {
        startActivity(new Intent(this, ActionReturnPage2.class));
    }
}
