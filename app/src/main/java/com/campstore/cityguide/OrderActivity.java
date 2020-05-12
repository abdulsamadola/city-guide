package com.campstore.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.campstore.cityguide.util.OrderViewPagerAdapter;

public class OrderActivity extends AppCompatActivity {
private ViewPager mViewPager;
private OrderViewPagerAdapter mOrderViewPagerAdapter;
private TextView completedLabel, pendingLabel, cancelLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        completedLabel = findViewById(R.id.completedLabel);
        pendingLabel = findViewById(R.id.pendingLabel);
        cancelLabel = findViewById(R.id.cancelLabel);

        completedLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });

        pendingLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
            }
        });

        cancelLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
            }
        });



        handleFragmentCall();
        onFragmentChange();


    }

    private void onFragmentChange() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    completedLabel.setTextColor(getResources().getColor(R.color.active));
                    completedLabel.setTextSize(22);

                    pendingLabel.setTextColor(getResources().getColor(R.color.not_active));
                    pendingLabel.setTextSize(18);

                    cancelLabel.setTextColor(getResources().getColor(R.color.not_active));
                    cancelLabel.setTextSize(18);
                }

            if(position == 1){
                pendingLabel.setTextColor(getResources().getColor(R.color.active));
                pendingLabel.setTextSize(22);

                completedLabel.setTextColor(getResources().getColor(R.color.not_active));
                completedLabel.setTextSize(18);

                cancelLabel.setTextColor(getResources().getColor(R.color.not_active));
                cancelLabel.setTextSize(18);
            }

            if(position == 2){
                cancelLabel.setTextColor(getResources().getColor(R.color.active));
                cancelLabel.setTextSize(22);

                pendingLabel.setTextColor(getResources().getColor(R.color.not_active));
                pendingLabel.setTextSize(18);

                completedLabel.setTextColor(getResources().getColor(R.color.not_active));
                completedLabel.setTextSize(18);

            }



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void handleFragmentCall() {
        mOrderViewPagerAdapter = new OrderViewPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.orderViewPager);
        mViewPager.setAdapter(mOrderViewPagerAdapter);
    }

}
