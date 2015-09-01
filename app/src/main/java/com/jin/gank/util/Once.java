package com.jin.gank.util;

import android.content.Context;
import android.content.SharedPreferences;


public class Once {

    SharedPreferences mSharedPreferences;
    Context mContext;

    public Once(Context context) {
        mSharedPreferences = context.getSharedPreferences("once", Context.MODE_PRIVATE);
        mContext = context;
    }

    public void show(String tagKey, OnceCallback callback) {
        boolean isSecondTime = mSharedPreferences.getBoolean(tagKey, false);
        if (!isSecondTime) {
            callback.onOnce();
            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putBoolean(tagKey, true);
            editor.apply();
        }
    }

    public void show(int tagKeyResId, OnceCallback callback) {
        show(mContext.getString(tagKeyResId), callback);
    }

    public interface OnceCallback {
        void onOnce();
    }
}
