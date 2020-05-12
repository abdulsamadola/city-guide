package com.campstore.cityguide.util;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.campstore.cityguide.CancelFragment;
import com.campstore.cityguide.CompletedFragment;
import com.campstore.cityguide.PendingFragment;

public class OrderViewPagerAdapter extends FragmentPagerAdapter {
    public OrderViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment completedFragment = new CompletedFragment();
                return completedFragment;
            case 1:
                Fragment pendingFragment = new PendingFragment();
                return pendingFragment;
            case 2:
                Fragment cancelFragment = new CancelFragment();
                return cancelFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
