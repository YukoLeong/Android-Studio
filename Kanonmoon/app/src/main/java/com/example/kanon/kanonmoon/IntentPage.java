package com.example.kanon.kanonmoon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by kanon on 2/1/2016.
 */
public class IntentPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentpage);
    }

    public void doSomething(View view) {

        switch (view.getId()) {
            case R.id.IntentButton1:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://gamer.com.tw"));
                Intent chooser = Intent.createChooser(intent, "Open Website Using...");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
                break;
        }
    }
}
