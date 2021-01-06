package com.sunnyweather.android.ui.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sunnyweather.android.R;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }
}