package com.campstore.cityguide.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.campstore.cityguide.R;

public class SliderAdapter extends PagerAdapter {

    Context  context;
    LayoutInflater layoutInflater;

    int[] images = {
        R.drawable.cityapp,
        R.drawable.cityapp,
        R.drawable.cityapp,
        R.drawable.cityapp
    };

    int[] slider_descs = {
        R.string.slider_desc_1,
        R.string.slider_desc_2,
        R.string.slider_desc_3,
        R.string.slider_desc_4
    };

    int[] slider_titles = {
        R.string.slider_text1,
        R.string.slider_text2,
        R.string.slider_text3,
        R.string.slider_text4
    };

    public SliderAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
      layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
      View view = layoutInflater.inflate(R.layout.slider_row, container, false);



       //Hooks
        ImageView sliderImage = view.findViewById(R.id.slider_image);
        TextView sliderTitle = view.findViewById(R.id.slider_text);
        TextView sliderDesc = view.findViewById(R.id.slider_desc);


        sliderImage.setImageResource(images[position]);
        sliderTitle.setText(slider_titles[position]);
        sliderDesc.setText(slider_descs[position]);


        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((ConstraintLayout)object);

    }
}
