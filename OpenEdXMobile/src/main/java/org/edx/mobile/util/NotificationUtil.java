package org.edx.mobile.util;

import com.google.firebase.messaging.FirebaseMessaging;

import org.edx.mobile.core.IEdxEnvironment;
import org.edx.mobile.notifications.services.NotificationService;

public class NotificationUtil {

    public static void subscribeToTopics(IEdxEnvironment environment){
        if(environment.getConfig().getFirebaseConfig().areNotificationsEnabled()) {
            FirebaseMessaging.getInstance().subscribeToTopic(
                    NotificationService.NOTIFICATION_TOPIC_RELEASE
            );
        }
    }
}
