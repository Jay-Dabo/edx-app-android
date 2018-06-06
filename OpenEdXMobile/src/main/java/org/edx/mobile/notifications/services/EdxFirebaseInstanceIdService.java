package org.edx.mobile.notifications.services;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.FirebaseInstanceId;
import android.util.Log;

import org.edx.mobile.logger.Logger;

public class EdxFirebaseInstanceIdService extends FirebaseInstanceIdService {
    protected static final Logger logger = new Logger(NotificationService.class.getName());


    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        logger.debug("Refreshed token: " + refreshedToken);
    }

}
