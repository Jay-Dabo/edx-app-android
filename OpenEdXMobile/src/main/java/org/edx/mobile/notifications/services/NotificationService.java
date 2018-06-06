package org.edx.mobile.notifications.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import org.edx.mobile.logger.Logger;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.edx.mobile.R;
import org.edx.mobile.base.MainApplication;
import org.edx.mobile.core.IEdxEnvironment;
import org.edx.mobile.view.DiscoveryLaunchActivity;
import org.edx.mobile.view.SplashActivity;


public class NotificationService extends FirebaseMessagingService {
    public static final String NOTIFICATION_TOPIC_RELEASE = "edx_release_notification_android";
    private static final int NOTIFICATION_ID = 999;
    protected static final Logger logger = new Logger(NotificationService.class.getName());

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        IEdxEnvironment environment = MainApplication.getEnvironment(this);

        if(!environment.getConfig().getFirebaseConfig().areNotificationsEnabled()){
            // Do not process Notifications when they are disabled.
            return;
        }

        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getNotification() != null) {
            logger.debug(
                    "Message Notification Body: " + remoteMessage.getNotification().getBody()
            );
        }

        // Build out the Notification and set the intent to direct the user to the application
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle(remoteMessage.getNotification().getTitle())
                        .setContentText(remoteMessage.getNotification().getBody());
        Intent resultIntent = new Intent(this, SplashActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(DiscoveryLaunchActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        builder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // NotificationId is a unique integer your app uses to identify the
        // notification. For example, to cancel the notification, you can pass its ID
        // number to NotificationManager.cancel(). We are currently using a hard coded
        // id, this could be improved in the future if we have Notification IDs added.
        Notification notification = builder.build();
        if(notification != null){
            try {
                notificationManager.notify(NOTIFICATION_ID, notification);
            } catch (NullPointerException ex){
                logger.error(ex);
            }
        }



    }
}
