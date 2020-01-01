package com.ryutta.monkingmobile;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Space;

import androidx.appcompat.app.AppCompatActivity;

import com.ryutta.monkingmobile.ui.login.LoginActivity;
import com.ryutta.monkingmobile.ui.main.MainActivity;
import com.ryutta.monkingmobile.utils.SharedPrefUtils;

public class SplashActivity extends AppCompatActivity {

    private static final String USER_TOKEN = "Bearer ";
    private static final String SHARED_PREF_LOGIN = "loginStatus";
    private static final String SHARED_PREF= "MoneyKing";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start home activity
//        checkApi();
//        checkLogin();
        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        moveToLogin();

        // close splash activity
        finish();
    }


    private void checkLogin() {
//        String login_status = sharedPreferences.getString(SHARED_PREF_LOGIN, "");
//        String user_token = sharedPreferences.getString(USER_TOKEN, "");

//        moveToActivity(this, MainActivity.class);
        moveToActivity(this, LoginActivity.class);
//        if (login_status.isEmpty()){
//            moveToActivity(this, LoginActivity.class);
//        } else {
//            moveToActivity(this, MainActivity.class);
//        }
    }

    private void moveToLogin(String user_token) {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        intent.putExtra("user_token", user_token);

        startActivity(intent);
    }

    private void moveToLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
//        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//        intent.putExtra("user_token", user_tokenen);
        startActivity(intent);
    }

    private void moveToActivity(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity, cls);

        startActivity(intent);
    }

}
