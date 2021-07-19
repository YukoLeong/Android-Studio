package com.example.kanon.kanonmoon;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

    String classes[] = {"MainActivity", "Method", "Gesture", "Submit_Tab_Test", "FileReadWrite", "Calculator", "ReadFile01", "ReadFile02", "StringArray", "StringArray2", "EnglishTest", "Notification", "DataSend1", "SpinnerTest", "ListViewTest", "PopupMenuTest", "WidgetTest", "DifferentLanguage", "ActionReturnBar", "AsyncDownload", "SwipeViewTest1", "SwipeViewImage", "Recyclerview", "MSSQL_Search", "MSSQL_Spinner", "MSSQL_UploadImage", "MSSQL_ShowImage", "MSSQL_Login"};
    // 不是manifest名

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        // WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        // String cheese = classes[4];
        String cheese = classes[position];
        try {
            // Class ourClass = Class.forName("android.intent.action."+ cheese);
            Class ourClass = Class.forName(this.getPackageName() + "." + cheese);
            Intent ourIntent = new Intent(this, ourClass);
            // Intent ourIntent = new Intent(this,
            // Class.forName(this.getPackageName() + "." + cheese));
            // //要用this.getPackageName()的格式
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
