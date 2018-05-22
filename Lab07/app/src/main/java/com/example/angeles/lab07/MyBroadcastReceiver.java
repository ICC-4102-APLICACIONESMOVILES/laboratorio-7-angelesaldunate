package com.example.angeles.lab07;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Angeles on 5/22/2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {

            Intent intent1 = new Intent(context, MyBroadcastReceiver2.class);
            intent1.setAction("android.intent.action.ALARM");
            //context.sendBroadcast(intent1);

            alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            alarmIntent = PendingIntent.getBroadcast(context, 0, intent1, 0);

            alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_HALF_HOUR/180,
                    AlarmManager.INTERVAL_HALF_HOUR/180, alarmIntent);
            Toast.makeText(context, "BrodcastReceiver Activated 1", Toast.LENGTH_SHORT).show();

        }

    }
}
