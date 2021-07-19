package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;


/**
 * Created by kanon on 9/29/2015.
 */
public class Gesture extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private TextView textView2;
    private GestureDetectorCompat gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_layout);

        textView2 = (TextView) findViewById(R.id.textView2);
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    //begin gestures

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        textView2.setText("onSingleTap!");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        textView2.setText("onDoubleTap!");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        textView2.setText("onDoubleTapEvent!");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        textView2.setText("onDown!");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        textView2.setText("onShowPress!");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        textView2.setText("onSingleTapUp!");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        textView2.setText("onScroll!");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        textView2.setText("onLongPress!");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        textView2.setText("onFling!");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

}
