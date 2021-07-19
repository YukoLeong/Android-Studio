package com.example.kanon.kanonmoon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kanon on 2/16/2016.
 */
public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.RecyclerViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;

    ArrayList<Recyclerview_ListProvider> arrayList = new ArrayList<Recyclerview_ListProvider>();

    public Recyclerview_Adapter(ArrayList<Recyclerview_ListProvider> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerViewHolder recyclerViewHolder;
        if (viewType == TYPE_LIST) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_layout, parent, false);
            recyclerViewHolder = new RecyclerViewHolder(view, viewType);

            return recyclerViewHolder;
        } else if (viewType == TYPE_HEAD) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_head_layout, parent, false);
            recyclerViewHolder = new RecyclerViewHolder(view, viewType);

            return recyclerViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Recyclerview_ListProvider recyclerview_listProvider;

        if (holder.view_type == TYPE_LIST) {
            recyclerview_listProvider = arrayList.get(position - 1);
            holder.list_image.setImageResource(recyclerview_listProvider.getImage_id());
            holder.list_country.setText(recyclerview_listProvider.getName());
            holder.list_capital.setText(recyclerview_listProvider.getCapital());
        } else if (holder.view_type == TYPE_HEAD) {
            holder.title_flag.setText("FLAG");
            holder.title_country.setText("COUNTRY");
            holder.title_captial.setText("CAPITAL");
        }


    }

    @Override
    public int getItemCount() {
        return arrayList.size() + 1;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        int view_type;
        ImageView list_image;
        TextView list_country, list_capital;

        TextView title_flag, title_country, title_captial;

        public RecyclerViewHolder(View view, int viewType) {
            super(view);
            if (viewType == TYPE_LIST) {
                list_image = (ImageView) view.findViewById(R.id.flag_id);
                list_country = (TextView) view.findViewById(R.id.country_id);
                list_capital = (TextView) view.findViewById(R.id.capital_id);
                view_type = 1;
            } else if (viewType == TYPE_HEAD) {
                title_flag = (TextView) view.findViewById(R.id.h_flag);
                title_country = (TextView) view.findViewById(R.id.h_Country);
                title_captial = (TextView) view.findViewById(R.id.h_capital);
                view_type = 0;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEAD;
        return TYPE_LIST;
    }
}
