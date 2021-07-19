package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwipeFragment1 extends Fragment {

    TextView textView;

    public SwipeFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.swipelayout, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        textView.setText("This is the " + message + " Swipe View Page..");

        return view;
    }
}
