package com.example.thestylist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(Splash.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2000)
                .withFooterText("Created by Mumbi")
                .withLogo(R.mipmap.style);

        config.getFooterTextView().setTextColor(Color.WHITE);
        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}
