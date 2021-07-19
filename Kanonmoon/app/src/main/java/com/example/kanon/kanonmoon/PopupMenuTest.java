package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

/**
 * Created by kanon on 1/27/2016.
 */
public class PopupMenuTest extends AppCompatActivity implements OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupmenu);

        findViewById(R.id.popupButton).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(PopupMenuTest.this, view);
                popupMenu.setOnMenuItemClickListener(PopupMenuTest.this);
                popupMenu.inflate(R.menu.popup_actions);
                popupMenu.show();
            }
        });
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Comedy Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Movies Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Music Clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }
}
