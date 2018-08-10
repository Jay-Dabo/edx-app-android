package org.edx.mobile.social.facebook;

import android.app.Activity;
import android.content.Intent;

import com.facebook.login.LoginManager;

import org.edx.mobile.social.ISocialImpl;

public class FacebookAuth extends ISocialImpl {

    public FacebookAuth(Activity activity) {
        super(activity);
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {
        LoginManager.getInstance().logOut();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
