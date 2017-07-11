package org.openstreetmap.sotmlatam.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import org.openstreetmap.sotmlatam.MainActivity;
import org.openstreetmap.sotmlatam.ProgramActivity;
import org.openstreetmap.sotmlatam.R;
import org.openstreetmap.sotmlatam.SplashActivity;

/**
 * Created by laura on 11/12/2016.
 */

public class Receiver extends android.content.BroadcastReceiver {

    @Override
    public void onReceive(android.content.Context context, android.content.Intent intent) {



        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("SotMLatam")
                .setContentText(context.getString(R.string.notification_text)+" " +intent.getStringExtra("eventName")+" "+
                        context.getString(R.string.sotm_title2));
        Intent resultIntent = new Intent(context, ProgramActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
        Vibrator vibrator = (Vibrator) context
                .getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1500);
    }
}
