package com.ryutta.monkingmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ryutta.monkingmobile.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start home activity
        SharedPreferences sharedPreferences = getSharedPreferences("")
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));

        // close splash activity
        finish();
    }

}
