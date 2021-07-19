package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by kanon on 2/5/2016.
 */
public class SwipeAdapter1 extends FragmentStatePagerAdapter {

    public SwipeAdapter1(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new SwipeFragment1();
        Bundle bundle = new Bundle();
        bundle.putInt("count", i + 1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
