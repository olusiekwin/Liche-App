package com.example.licheapp.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licheapp.R;

import java.util.ArrayList;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder> {

    ArrayList<FeaturedHelperClass> featuredArtwork;

    public FeatureAdapter(ArrayList<FeaturedHelperClass> featuredArtwork) {
        this.featuredArtwork = featuredArtwork;
    }

    @NonNull
    @Override
    public FeatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_cardview_design, parent, false);
        FeatureViewHolder featureViewHolder = new FeatureViewHolder(view);
        return featureViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredArtwork.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredArtwork.size();
    }

    public static class FeatureViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        public FeatureViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.feature_image);
            title = itemView.findViewById(R.id.feature_title);
            desc = itemView.findViewById(R.id.feature_desc);

        }
    }
}
