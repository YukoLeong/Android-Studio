package com.example.kanon.kanonmoon;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanon on 2/1/2016.
 */
public class SQL_ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public SQL_ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler {
        TextView NAME, MOB, EMAIL;
    }


    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.sql_rowlayout, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME = (TextView) row.findViewById(R.id.addtext1);
            layoutHandler.MOB = (TextView) row.findViewById(R.id.addtext2);
            layoutHandler.EMAIL = (TextView) row.findViewById(R.id.addtext3);
            row.setTag(layoutHandler);
        } else {
            layoutHandler = (LayoutHandler) row.getTag();
        }
        SQL_DataProvider sql_dataProvider = (SQL_DataProvider) this.getItem(position);
        layoutHandler.NAME.setText(sql_dataProvider.getName());
        layoutHandler.MOB.setText(sql_dataProvider.getMob());
        layoutHandler.EMAIL.setText(sql_dataProvider.getEmail());
        return super.getView(position, convertView, parent);
    }

}
