package com.example.travel.travel.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yue on 2016/10/29.
 */

public class SharedPreferencesUtils {
    public static String getString(Context context,String fliename) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userid", context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
        return  sharedPreferences.getString("userid",null);
    }

}
