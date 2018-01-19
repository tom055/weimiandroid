package com.dql.g150t.fyhs.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ST on 2017/8/15.
 */

public class SharedPreferencesUtil {
    private static final String spFileName = "welcomePage";
    public static final String FIRST_OPEN = "first_open";
    public static final String FIRST_START = "first_start";

    public static Boolean getBoolean(Context context, String strKey,
                                     Boolean strDefault) {//strDefault	boolean: Value to return if this preference does not exist.
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        Boolean result = setPreferences.getBoolean(strKey, strDefault);
        return result;
    }

    public static void putBoolean(Context context, String strKey,
                                  Boolean strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putBoolean(strKey, strData);
        editor.commit();
    }


}
