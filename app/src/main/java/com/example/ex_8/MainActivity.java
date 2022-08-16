package com.example.ex_8;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActionBar actionbar = getSupportActionBar();
//        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.night_sky,null));
    }
}