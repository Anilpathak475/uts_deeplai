package com.example.androidexamp.example.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.androidexamp.example.BuildConfig;

/**
 * Created by anilpathak on 05/09/17.
 */

public class SharedPreferenceManager {
    //default preferences name
    public Context context;

    private SharedPreferenceManager(Context context) {
        this.context = context;
    }

    public static SharedPreferenceManager getInstance(Context context) {
        return new SharedPreferenceManager(context);
    }

    public void saveValue(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void clearValue(String key) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.remove(key);
        editor.apply();
    }

    public void clearUserData() {
        getSharedPreferences().getAll().clear();
    }

    public String getValue(String key) {
        return getSharedPreferences().getString(key, "");
    }


    private SharedPreferences getSharedPreferences() {
        String PREF_NAME = BuildConfig.APPLICATION_ID + ".Prefs";
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
}
