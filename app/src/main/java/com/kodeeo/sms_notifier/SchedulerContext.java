package com.kodeeo.sms_notifier;

import android.app.Application;

import com.kodeeo.sms_notifier.db.DatabaseManager;
import com.kodeeo.sms_notifier.util.ContactsManager;

/**
 * Created by dobrikostadinov on 5/7/15.
 */
public class SchedulerContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Crashlytics.start(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ContactsManager.getInstance(SchedulerContext.this);

            }
        }).start();

        DatabaseManager.init(SchedulerContext.this);
        DatabaseManager.getInstance().requestAllDbItems();
    }
}
