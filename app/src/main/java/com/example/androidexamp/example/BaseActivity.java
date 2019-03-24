package com.example.androidexamp.example;

import android.os.Bundle;

import com.example.androidexamp.example.utils.SharedPreferenceManager;
import com.example.androidexamp.example.utils.UiUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public SharedPreferenceManager sharedPreferenceManager;
    public UiUtils uiUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(this);
        uiUtils = new UiUtils(this);
    }
}
