package de.newschool.newschool_lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ASUS on 04.08.2016.
 */
public class LockscreenReceiver extends BroadcastReceiver {

    public static boolean screenOn;
    @Override
    public void onReceive(Context context, Intent intent) {


        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            screenOn = false;

        }else{
            if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
                screenOn = true;
                Intent intent1 = new Intent(context, Lockscreen.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }else{

                if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
                    Toast.makeText(context,"boot completed",Toast.LENGTH_LONG).show();

                    Intent intent11 = new Intent(context, Lockscreen.class);
                    intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
            }
        }
    }
}
