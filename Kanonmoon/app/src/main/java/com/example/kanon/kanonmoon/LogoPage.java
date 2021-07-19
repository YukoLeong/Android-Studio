package com.example.kanon.kanonmoon;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by kanon on 9/23/2015.
 */
public class LogoPage extends Activity {

    // MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.logopage_layout); // set layout location

//        MediaPlayer ourSong = MediaPlayer.create(this, R.raw.music01);

//        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//        boolean music = getPrefs.getBoolean("checkbox", true);
//        if (music == true) {
//            ourSong.start();
//        }


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openindex = new Intent("android.intent.action.MM");
//                  Intent openindex = new Intent("android.intent.action.Page2");
                    startActivity(openindex);
                }
            }
        };
        timer.start();
    }

    protected void onPause() {
        super.onPause();
        // ourSong.stop();
        finish();
    }
}

