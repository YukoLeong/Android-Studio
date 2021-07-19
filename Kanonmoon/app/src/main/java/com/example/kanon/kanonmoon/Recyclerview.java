package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by kanon on 2/16/2016.
 */
public class Recyclerview extends AppCompatActivity {

    RecyclerView recyclerView;
    Recyclerview_Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Recyclerview_ListProvider> arrayList = new ArrayList<Recyclerview_ListProvider>();
    String[] Name, Capital;
        int[] img_id = {R.drawable.recyclerview_india, R.drawable.recyclerview_australia, R.drawable.recyclerview_united_arab_emirates, R.drawable.recyclerview_thailand,R.drawable.recyclerview_netherlands, R.drawable.recyclerview_sri_lanka, R.drawable.recyclerview_new_zealand, R.drawable.recyclerview_malaysia};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Name = getResources().getStringArray(R.array.recyclerviewlist1);
        Capital = getResources().getStringArray(R.array.recyclerviewlist2);
        int count = 0;
        for (String NAME : Name) {
            Recyclerview_ListProvider recyclerview_listProvider = new Recyclerview_ListProvider(img_id[count], NAME, Capital[count]);
            arrayList.add(recyclerview_listProvider);
            count++;
        }
        adapter = new Recyclerview_Adapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
