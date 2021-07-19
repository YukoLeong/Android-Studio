package com.example.kanon.kanonmoon;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;

/**
 * Created by kanon on 1/11/2016.
 */
public class ReadFile01 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readfile01);

        TextView txtContent = (TextView) findViewById(R.id.tv1);
        TextView txtFileName = (TextView) findViewById(R.id.tv2);
        ImageView iv = (ImageView) findViewById(R.id.iv);

        AssetManager assetManager = getAssets();
        try {
            String[] files = assetManager.list("Files");
            for (int i = 0; i < files.length; i++) {
                txtContent.append("\n Files=>" + i + "Name" + files);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream in = assetManager.open("icon01.png");
            Drawable d = Drawable.createFromStream(in, null);
            iv.setImageDrawable(d);
        } catch (Exception e) {
            return;
        }

        InputStream input;
        try {
            input = assetManager.open("text.txt");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            String text = new String(buffer);
            txtFileName.setText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
