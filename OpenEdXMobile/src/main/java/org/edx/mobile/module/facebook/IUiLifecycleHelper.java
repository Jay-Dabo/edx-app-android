//package org.edx.mobile.module.facebook;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//
//import com.facebook.Session;
//import com.facebook.widget.FacebookDialog;
//
///**
// * Created by rohan on 2/12/15.
// */
//public interface IUiLifecycleHelper {
//
//
//    void onCreate(Bundle savedInstanceState);
//
//    void onActivityResult(int requestCode, int resultCode, Intent data);
//
//    void onResume();
//
//    void onPause();
//
//    void onStop();
//
//    void onDestroy();
//
//    void onSaveInstanceState(Bundle outState);
//
//    class Factory {
//
//        /**
//         * Returns instance of {@link org.edx.mobile.module.facebook.IUiLifecycleHelperImpl} class.
//         * @param activity
//         * @return
//         */
//        public static IUiLifecycleHelper getInstance(Activity activity) {
//            return new IUiLifecycleHelperImpl(activity);
//        }
//    }
//}
