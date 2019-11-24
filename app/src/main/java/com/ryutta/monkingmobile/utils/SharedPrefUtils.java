package com.ryutta.monkingmobile.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private  static void initSharedPref(String namaPref, Context context){
        sharedPreferences = context.getSharedPreferences(namaPref, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void setStringSharedPref(String key, String values){
        editor.putString(key, values);
        editor.apply();
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
