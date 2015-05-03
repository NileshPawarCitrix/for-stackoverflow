package com.hello.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


public class NoteAlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        NotificationCompat.Builder mBuilder = new
                NotificationCompat.Builder(context)
                .setContentTitle("My Notification")
                .setContentText("Hello World!")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher);

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        int currentapiVersion = android.os.Build.VERSION.SDK_INT;

        Notification notification;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification = mBuilder.build();
        } else {
            notification = mBuilder.getNotification();
        }

        notificationManager.notify(0x1111, notification);

        Log.i("HELLO", "Alarm has been called!");
    }
}
