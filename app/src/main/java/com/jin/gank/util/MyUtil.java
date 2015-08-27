package com.jin.gank.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2015/8/27.
 */
public class MyUtil {


    //  获取Android获得屏幕的宽和高
    public static int[] getScrren(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int[] screen = new int[2];
        screen[0] = (int) (dm.widthPixels * dm.density);
        screen[1] = (int) (dm.heightPixels * dm.density);
        return screen;
    }
}
