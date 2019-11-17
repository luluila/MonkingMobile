package com.ryutta.monkingmobile.base;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected ProgressBar progressBar;

    protected void OnCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        progressBar = new ProgressBar(this);
    }

}
