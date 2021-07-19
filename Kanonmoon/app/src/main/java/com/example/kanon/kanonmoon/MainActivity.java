package com.example.kanon.kanonmoon;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.Menu;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout background;
    Button btnGreen, btnBlue;

    private static final String TAG = "This is Message";

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");

        background = (RelativeLayout) findViewById(R.id.background);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnBlue = (Button) findViewById(R.id.btnBlue);

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.parseColor("#00C400"));
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.parseColor("#006699"));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    public void onGroupItemClick(MenuItem item) {
//        // One of the group items (using the onClick attribute) was clicked
//        // The item parameter passed here indicates which item it is
//        // All other menu item clicks are handled by onOptionsItemSelected()
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.background);

        switch (item.getItemId()) {
            case R.id.mmred:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                background.setBackgroundColor(Color.RED);
                return true;
            case R.id.mmgreen:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                background.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.mmyellow:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                background.setBackgroundColor(Color.YELLOW);
//                    this.startActivity(new Intent(this, Gesture.class));
                return true;
            case R.id.mmjump:
                if (item.isChecked())
                    item.setChecked(false);
                else
//                    item.setChecked(true);
//                background.setBackgroundColor(Color.YELLOW);
                    this.startActivity(new Intent(this, Gesture.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void displayToast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
