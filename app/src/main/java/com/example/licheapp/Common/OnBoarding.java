package com.example.licheapp.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.licheapp.HelperClasses.SliderAdapter;
import com.example.licheapp.R;
import com.example.licheapp.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayouts;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button GetStarted;
    Animation animation;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //removing status bar while On-boarding
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_on_boarding);

        // Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayouts = findViewById(R.id.dots);
        GetStarted = findViewById(R.id.get_started_btn);

        // Call adapters
        sliderAdapter = new SliderAdapter(this);

        //...Dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }
    public void skip(View view ){
        startActivity(new Intent(this, UserDashboard.class));
        finish();
    }
    public void next(View view){

        viewPager.setCurrentItem(currentPosition + 1);
    }

    private void addDots(int position) {

        dots = new TextView[4];
        dotsLayouts.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayouts.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition = position;


            if (position == 0) {
                GetStarted.setVisibility(View.INVISIBLE);
            }
            else if (position == 1) {
                GetStarted.setVisibility(View.INVISIBLE);
            }
            else if(position == 2){
                GetStarted.setVisibility(View.INVISIBLE);
            }
            else {
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                GetStarted.setAnimation(animation);
                GetStarted.setVisibility(View.VISIBLE);
            }
        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}