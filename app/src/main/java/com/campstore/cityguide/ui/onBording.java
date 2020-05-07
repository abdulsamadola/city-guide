package com.campstore.cityguide.ui;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.campstore.cityguide.Dasboard;
import com.campstore.cityguide.R;
import com.campstore.cityguide.util.SliderAdapter;

public class onBording extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] textViews;
    Button startBtn;
    Animation animation;
    Button nextBtn, skipBtn;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_bording);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dot_layout);
        startBtn = findViewById(R.id.start_btn);
        nextBtn = findViewById(R.id.next_btn);
        skipBtn = findViewById(R.id.skip_btn);

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);


        add3dots(0);

        viewPager.addOnPageChangeListener(onPageChangeListener);


        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(onBording.this, Dasboard.class));
                finish();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPosition == sliderAdapter.getCount()-1){
                    nextBtn.setVisibility(View.INVISIBLE);
                }else {
                    nextBtn.setVisibility(View.VISIBLE);
                    viewPager.setCurrentItem(currentPosition+1);
                }

            }
        });


    }

    public void add3dots(int position) {
        textViews = new TextView[4];
        dotsLayout.removeAllViews();

        for(int i = 0; i < textViews.length; i++){
            textViews[i] = new TextView(this);
            textViews[i].setText(Html.fromHtml("&#8226;"));
            textViews[i].setTextSize(35);
            dotsLayout.addView(textViews[i]);
        }

        if(textViews.length > 0){
            textViews[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

        if (position != sliderAdapter.getCount()-1){
            startBtn.setVisibility(View.INVISIBLE);

        }else {

            startBtn.setVisibility(View.VISIBLE);
            animation = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
            startBtn.setAnimation(animation);


        }

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(final int position) {

            add3dots(position);
            currentPosition = position;
            if(currentPosition == sliderAdapter.getCount()-1){
                nextBtn.setVisibility(View.INVISIBLE);
            }else {
                nextBtn.setVisibility(View.VISIBLE);
                //viewPager.setCurrentItem(currentPosition+1);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
