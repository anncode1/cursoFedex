package com.anncode.androidnotificationsfirebase.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;


import com.anncode.androidnotificationsfirebase.MainActivity;
import com.anncode.androidnotificationsfirebase.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by anahisalgado on 08/07/16.
 */
public class MessagingServiceFirebase extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String title = remoteMessage.getFrom();
        String message = remoteMessage.getNotification().getBody();
        buildNotification(remoteMessage);
    }

    public void buildNotification(RemoteMessage remoteMessage){

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("FedEx")
                .setContentText(remoteMessage.getNotification().getBody())
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setSound(sound)
                ;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification.build());


    }
}
