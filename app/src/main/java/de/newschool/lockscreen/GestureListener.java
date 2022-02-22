package de.newschool.newschool_lockscreen;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by ASUS on 04.08.2016.
 */
public class GestureListener extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
