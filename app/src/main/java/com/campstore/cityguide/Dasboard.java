package com.campstore.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.campstore.cityguide.model.Category;
import com.campstore.cityguide.model.FeaturedLocation;
import com.campstore.cityguide.model.MostView;
import com.campstore.cityguide.util.CategoryAdapter;
import com.campstore.cityguide.util.FeaturedLocationAdapter;
import com.campstore.cityguide.util.MostViewAdapter;

import java.util.ArrayList;

public class Dasboard extends AppCompatActivity {

    public RecyclerView featureRecycler;
    public RecyclerView mostViewRecycler;
    public RecyclerView categoryRecyclerView;
    public ArrayList<FeaturedLocation> mFeaturedLocations;
    public ArrayList<MostView> mMostViews;
    public ArrayList<Category> mCategories;
    public ArrayList<GradientDrawable> mGradientDrawables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        featureRecycler = findViewById(R.id.featureRecycler);
        mostViewRecycler = findViewById(R.id.mostViewRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

        mFeaturedLocations = new ArrayList<>();
        mMostViews = new ArrayList<>();
        mCategories = new ArrayList<>();
        mGradientDrawables = new ArrayList<>();

        featuredRecylerHandler();
        mostViewRecyclerHandler();
        categoryRecyclerViewHandler();

    }

    private void categoryRecyclerViewHandler() {

        categoryRecyclerView.setHasFixedSize(true);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        mGradientDrawables.add(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{
            R.color.colorAccent, R.color.colorPrimary
        }));

        mGradientDrawables.add(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{
                        0xccc1a541, 0xccff6600
                }));
        mGradientDrawables.add(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{
                        0xff660000, 0xffcc660
                }));
        mGradientDrawables.add(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{0xffcc6600, 0xffcc6600
                }));

        mCategories.add(new Category(R.drawable.accuracy_icon, "Education"));
        mCategories.add(new Category(R.drawable.elegant_icon, "Commerce"));
        mCategories.add(new Category(R.drawable.accuracy_icon, "Literature"));
        mCategories.add(new Category(R.drawable.scalable_icon, "Computer"));

        CategoryAdapter categoryAdapter = new CategoryAdapter(mCategories, mGradientDrawables);

        categoryRecyclerView.setAdapter(categoryAdapter);

    }

    private void mostViewRecyclerHandler() {
        mostViewRecycler.setHasFixedSize(true);
        mostViewRecycler.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        mMostViews.add(new MostView(R.drawable.elegant_icon, R.string.slider_desc_3, "Goody bag " +
                "look"));

        mMostViews.add(new MostView(R.drawable.accuracy_icon, R.string.slider_desc_2, "Lovelace " +
                "Ada" +
                " " +
                "look"));

        mMostViews.add(new MostView(R.drawable.confirmed_icon, R.string.slider_desc_1, "Kingo " +
                "plaza"));

        MostViewAdapter mostViewAdapter = new MostViewAdapter(mMostViews);
        mostViewRecycler.setAdapter(mostViewAdapter);
    }



    private void featuredRecylerHandler() {

        featureRecycler.setHasFixedSize(true);
        featureRecycler.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        mFeaturedLocations.add(new FeaturedLocation(R.drawable.accuracy_icon,"We are human",
                R.string.slider_desc_1));
        mFeaturedLocations.add(new FeaturedLocation(R.drawable.elegant_icon,"We are kings",
                R.string.slider_desc_1));
        mFeaturedLocations.add(new FeaturedLocation(R.drawable.confirmed_icon,"We are soldiers",
                R.string.slider_desc_1));

        FeaturedLocationAdapter featuredLocationAdapter =
                new FeaturedLocationAdapter(mFeaturedLocations);

        featureRecycler.setAdapter(featuredLocationAdapter);

    }

    public void openDrawer(View view) {
        startActivity(new Intent(Dasboard.this, OrderActivity.class));
    }
}
