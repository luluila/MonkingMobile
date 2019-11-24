package com.ryutta.monkingmobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ryutta.monkingmobile.ui.login.LoginActivity;
import com.ryutta.monkingmobile.utils.SharedPrefUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start home activity
        startActivity(new Intent(SplashActivity.this, MainActivity.class));

        // close splash activity
        finish();
    }

}
