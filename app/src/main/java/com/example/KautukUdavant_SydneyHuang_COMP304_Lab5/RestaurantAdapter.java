package com.example.KautukUdavant_SydneyHuang_COMP304_Lab5;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kautukudavant_sydneyhuang_comp304_lab5.R;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.LandmarkHolder> {

    private final Restaurants[] landmarks;

    public RestaurantAdapter(@NonNull Restaurants[] data) {
        landmarks = data;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup p, int type) {
        LayoutInflater in = LayoutInflater.from(p.getContext());
        View view = in.inflate(R.layout.restaurant_view, p, false);
        return new LandmarkHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int i) {
        Log.d("onBindViewHolder", landmarks[i].getName());
        holder.setLandmarks(landmarks[i]);
    }

    @Override
    public int getItemCount() {
        return landmarks.length;
    }

    public static class LandmarkHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Restaurants restaurants;

        private final TextView nameTextView, typeTextView, addressTextView;

        public LandmarkHolder(@NonNull View view) {
            super(view);
            nameTextView = view.findViewById(R.id.landmarkNameTextView);
            typeTextView = view.findViewById(R.id.landmarkTypeTextView);
            addressTextView = view.findViewById(R.id.landmarkAddressTextView);

            view.setOnClickListener(this);
        }

        public void setLandmarks(Restaurants restaurants) {
            this.restaurants = restaurants;
            nameTextView.setText(restaurants.getName());
            addressTextView.setText(restaurants.getAddress());

            RestaurantType type = restaurants.getType();
            typeTextView.setText(String.format("%s", type));
            typeTextView.setTextColor(type.getColorFrom(itemView));
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(itemView.getContext(),
                "Clicked " + restaurants.getName(),
                Toast.LENGTH_SHORT).show();

            Context ctx = v.getContext();
            Intent in = new Intent(ctx, MapsActivity.class);
            in.putExtra(Restaurants.ID_EXTRA, restaurants.getLandmarkId());
            ctx.startActivity(in);
        }
    }
}
