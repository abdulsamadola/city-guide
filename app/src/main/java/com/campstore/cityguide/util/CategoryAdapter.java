package com.campstore.cityguide.util;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campstore.cityguide.R;
import com.campstore.cityguide.model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private ArrayList<Category> mCategories;
    private ArrayList<GradientDrawable> mGradientDrawable;

    public CategoryAdapter(ArrayList<Category> categories,
                           ArrayList<GradientDrawable> gradientDrawables) {
        mCategories = categories;
        mGradientDrawable = gradientDrawables;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view_card,
                parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mCategories.get(position);
        holder.cBackground.setBackground(mGradientDrawable.get(position));
        holder.cname.setText(category.getName());
        holder.cimg.setImageResource(category.getImg());

    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }


    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public TextView cname = itemView.findViewById(R.id.cname);
        public ImageView cimg = itemView.findViewById(R.id.cimg);
        public RelativeLayout cBackground = itemView.findViewById(R.id.categoryBG);
    }
}
