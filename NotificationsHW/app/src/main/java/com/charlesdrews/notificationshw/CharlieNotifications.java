package com.charlesdrews.notificationshw;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

/**
 * Created by charlie on 2/29/16.
 */
public class CharlieNotifications {
    public static void gregMillerNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.gregmiller));
        builder.setSmallIcon(R.drawable.ic_favorite_white_18dp);

        Intent intent = new Intent(context, context.getClass());
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, (int) System.currentTimeMillis(), intent, 0);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.setBigContentTitle("Greg Miller");
        style.bigText("Liked: Tim: \"It's cool that the @BatmanvSuperman movie cast the guy from Gigli.\""
                + "\n@GameOverGreggy: \"... Are you srsly making a joke right now, Tim?\"");
        builder.setStyle(style);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }

    public static void clearNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setSmallIcon(R.drawable.ic_view_list_white_18dp);
        builder.setContentTitle("Clear Notifications");

        Intent intent = new Intent(context, context.getClass());
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, (int) System.currentTimeMillis(), intent, 0);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, builder.build());
    }
}