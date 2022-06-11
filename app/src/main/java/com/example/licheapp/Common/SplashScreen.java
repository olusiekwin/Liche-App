package com.example.licheapp.Common;

import static android.view.animation.AnimationUtils.loadAnimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.licheapp.R;

public class SplashScreen<sharedPreferences> extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    // Variables
    ImageView backgroundImage;
    TextView poweredByLine;

    //Animations
    Animation sideAnim, bottomAnim;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Hooks
        backgroundImage = findViewById(R.id.background_image);
        poweredByLine = findViewById(R.id.powered_by_line);

        //Animations
        sideAnim = loadAnimation(this, R.anim.side_anim);
        bottomAnim = loadAnimation(this, R.anim.bottom_anim);

        //set anim on elements
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER);
    }
}