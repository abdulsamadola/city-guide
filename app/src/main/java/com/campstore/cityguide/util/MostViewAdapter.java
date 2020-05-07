package com.campstore.cityguide.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campstore.cityguide.R;
import com.campstore.cityguide.model.MostView;

import java.util.ArrayList;

public class MostViewAdapter extends RecyclerView.Adapter<MostViewAdapter.MostViewViewHolder> {

    ArrayList<MostView> mMostViews;

    public MostViewAdapter(ArrayList<MostView> mostViews) {
        mMostViews = mostViews;
    }

    @NonNull
    @Override
    public MostViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_view_card,
                parent, false);
        return new MostViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewViewHolder holder, int position) {

        MostView mostView = mMostViews.get(position);
        holder.mvImg.setImageResource(mostView.getImg());
        holder.mvTitle.setText(mostView.getTitle());
        holder.mvDesc.setText(mostView.getDesc());

    }

    @Override
    public int getItemCount() {
        return mMostViews.size();
    }


    public static class MostViewViewHolder extends RecyclerView.ViewHolder {

        public MostViewViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ImageView mvImg = itemView.findViewById(R.id.mv_img);
        public TextView mvTitle = itemView.findViewById(R.id.mv_title);
        public TextView mvDesc = itemView.findViewById(R.id.mv_desc);
    }
}
