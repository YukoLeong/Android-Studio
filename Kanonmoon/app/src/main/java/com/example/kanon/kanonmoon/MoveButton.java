package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by kanon on 9/30/2015.
 * https://www.youtube.com/watch?v=n4IyvL-ACbk
 * don't know why this don't work
 */




public class MoveButton extends AppCompatActivity {

    ViewGroup mb_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movebutton_layout);

        mb_layout = (ViewGroup) findViewById(R.id.mb_layout);

        mb_layout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        moveButton();
                        return true;
                    }
                }
        );
    }

    public void moveButton() {
        View mb_button = findViewById(R.id.mb_button);

        TransitionManager.beginDelayedTransition(mb_layout);

        //Change the position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        mb_button.setLayoutParams(positionRules);

        //Change the size of the button
        ViewGroup.LayoutParams sizeRules = mb_button.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        mb_button.setLayoutParams(sizeRules);
    }

}
