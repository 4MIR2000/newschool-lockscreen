package de.newschool.newschool_lockscreen;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by ASUS on 04.08.2016.
 */
public class LockscreenService extends Service {
    BroadcastReceiver receiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        KeyguardManager.KeyguardLock k1;

        KeyguardManager km = (KeyguardManager)getSystemService(KEYGUARD_SERVICE);
        k1 = km.newKeyguardLock("IN");
        k1.disableKeyguard();

        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);

        receiver = new LockscreenReceiver();
        registerReceiver(receiver,filter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //unregister  Receiver
    }
}
