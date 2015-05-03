package com.hello.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAlarm(this);
    }

    public void setAlarm(Context context)
    {

        Intent alarmIntent = new Intent(context, NoteAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis(),
                60* 1000, pendingIntent);
        Toast.makeText(context, "NoteAlarm.setAlarm() : Note " + "Note" + " has been set", Toast.LENGTH_LONG).show();
        Log.i("HELLO", "NoteAlarm.setAlarm() : Note " + "Note" + " has been set");
    }

}
