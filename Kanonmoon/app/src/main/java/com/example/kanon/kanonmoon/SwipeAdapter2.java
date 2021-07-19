package com.example.kanon.kanonmoon;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by kanon on 2/11/2016.
 */
public class SwipeAdapter2 extends PagerAdapter {

    private int[] image_resource = {R.drawable.megami1, R.drawable.megami2, R.drawable.megami3};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public SwipeAdapter2(Context ctx) {
        this.ctx = ctx;
    }


    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipelayout2, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.imageView);
        TextView textView = (TextView) item_view.findViewById(R.id.textView);
        imageView.setImageResource(image_resource[position]);
        textView.setText("Image: " + (int) (position + 1));
        container.addView(item_view);
        return item_view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
