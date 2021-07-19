package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kanon on 2/11/2016.
 */
public class SwipeViewImage extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipeviewtest1);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        SwipeAdapter2 swipeAdapter2 = new SwipeAdapter2(this);
        viewPager.setAdapter(swipeAdapter2);
    }
}
