package com.campstore.cityguide.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campstore.cityguide.R;
import com.campstore.cityguide.model.FeaturedLocation;

import java.util.ArrayList;

public class FeaturedLocationAdapter extends RecyclerView.Adapter<FeaturedLocationAdapter.FeaturedLocationViewHolder> {

    public ArrayList<FeaturedLocation> mFeaturedLocations;

    public FeaturedLocationAdapter(ArrayList<FeaturedLocation> featuredLocations) {
        mFeaturedLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View view =
              LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent,
                false);
        return new FeaturedLocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedLocationViewHolder holder, int position) {

        FeaturedLocation featuredLocation = mFeaturedLocations.get(position);
        holder.image.setImageResource(featuredLocation.getImage());
        holder.title.setText(featuredLocation.getTitle());
        holder.desc.setText(featuredLocation.getDesc());

    }

    @Override
    public int getItemCount() {
        return mFeaturedLocations.size();
    }


    public static class FeaturedLocationViewHolder extends RecyclerView.ViewHolder {

        public FeaturedLocationViewHolder(@NonNull View itemView) {
            super(itemView);

        }

      public ImageView image = itemView.findViewById(R.id.fc_img);
      public TextView title = itemView.findViewById(R.id.fc_title);
      public TextView desc = itemView.findViewById(R.id.fc_desc);
    }


}
