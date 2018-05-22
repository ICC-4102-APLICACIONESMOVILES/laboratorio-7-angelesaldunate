package com.example.angeles.lab07;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Angeles on 5/22/2018.
 */

public class MyBroadcastReceiver2 extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver2";
    private int ide=0;

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.ALARM".equals(intent.getAction())) {

            Intent intent1 = new Intent(context, MyBroadcastReceiver2.class);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("ALARM")
                    .setContentText("ALARM NOTIFICATION");
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            notificationManager.notify(ide,mBuilder.build());
            ide++;
            Toast.makeText(context, "Alarm Ring", Toast.LENGTH_SHORT).show();


        }
    }

}
