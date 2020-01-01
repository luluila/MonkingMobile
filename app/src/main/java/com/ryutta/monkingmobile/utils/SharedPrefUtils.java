package com.ryutta.monkingmobile.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static void initSharedPref(String namaPref, Context context){
        sharedPreferences = context.getSharedPreferences(namaPref, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void setStringSharedPref(String key, String values){
        editor.putString(key, values);
        editor.apply();
    }

    public static SharedPreferences getSharedPreferences(String sharedPrefLogin, String s) {
        return sharedPreferences;
    }

    public static void setBooleanSharedPref(String key, Boolean values){
        editor.putBoolean(key, values);
        editor.apply();
    }

    public static boolean getBooleanSharedPref(String key){
        return  sharedPreferences.getBoolean(key, false);
    }
}
