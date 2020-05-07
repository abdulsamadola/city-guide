package com.campstore.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.campstore.cityguide.ui.onBording;

public class MainActivity extends AppCompatActivity {
    private ImageView image_intro;
    private TextView text_intro;
    SharedPreferences sharedPreferences;

    private Animation intro_image_top, intro_text_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_intro = findViewById(R.id.intro_image);
        text_intro = findViewById(R.id.intro_text);

        intro_image_top = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        intro_text_bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
          image_intro.setAnimation(intro_image_top);
          text_intro.setAnimation(intro_text_bottom);


          new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
              sharedPreferences = getSharedPreferences("onBoarding", MODE_PRIVATE);
              boolean isFirstTime = sharedPreferences.getBoolean("firstTime", true);

              if(isFirstTime){

                  SharedPreferences.Editor editor = sharedPreferences.edit();
                  editor.putBoolean("firstTime", false).commit();


                  Intent intent = new Intent(MainActivity.this, onBording.class);
                  startActivity(intent);
                  finish();

              }else {

                  Intent intent = new Intent(MainActivity.this, Dasboard.class);
                  startActivity(intent);
                  finish();
              }


              }
          },5000);


    }
}
