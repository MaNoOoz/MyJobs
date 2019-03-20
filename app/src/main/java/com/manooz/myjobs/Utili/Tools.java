package com.manooz.myjobs.Utili;

import android.view.View;

public class Tools  {

    public static boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }
}
