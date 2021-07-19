package com.example.kanon.kanonmoon;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by kanon on 1/21/2016.
 */
public class Notification extends AppCompatActivity {

    String noticeText = "This is notice1 text" + "and this is line 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
    }

    public void check1(View view) {
        // Build the content of Notification
        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this);
        builder1.setTicker("hey This is Ticker..!!");
        builder1.setContentTitle("Notice Title1");
        builder1.setContentText(noticeText);
        builder1.setSmallIcon(R.drawable.orangeicon);
        builder1.setAutoCancel(true);

        // 按鍵傳送頁面 不用傳送功能的話可不填
        Intent i = new Intent(this, Menu.class);
        TaskStackBuilder stackbuilder = TaskStackBuilder.create(this);
        stackbuilder.addParentStack(Menu.class);
        stackbuilder.addNextIntent(i);
        PendingIntent pi_main = stackbuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder1.setContentIntent(pi_main);

        // Notification through notification Manager
        android.app.Notification notification1 = builder1.build();
        NotificationManager manager1 = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager1.notify(123, notification1);



    }


}
