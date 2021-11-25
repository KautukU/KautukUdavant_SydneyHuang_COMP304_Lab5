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

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder> {

    private final Restaurants[] restaurant;

    public RestaurantAdapter(@NonNull Restaurants[] data) {
        restaurant = data;
    }

    @NonNull
    @Override
    public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup p, int type) {
        LayoutInflater in = LayoutInflater.from(p.getContext());
        View view = in.inflate(R.layout.restaurant_view, p, false);
        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantHolder holder, int i) {
        Log.d("onBindViewHolder", restaurant[i].getName());
        holder.setRestaurant(restaurant[i]);
    }

    @Override
    public int getItemCount() {
        return restaurant.length;
    }

    public static class RestaurantHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Restaurants restaurants;

        private final TextView nameTextView, typeTextView, addressTextView;

        public RestaurantHolder(@NonNull View view) {
            super(view);
            nameTextView = view.findViewById(R.id.restaurantNameTextView);
            typeTextView = view.findViewById(R.id.restaurantTypeTextView);
            addressTextView = view.findViewById(R.id.restaurantAddressTextView);

            view.setOnClickListener(this);
        }

        public void setRestaurant(Restaurants restaurants) {
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
            in.putExtra(Restaurants.ID_EXTRA, restaurants.getRestaurantId());
            ctx.startActivity(in);
        }
    }
}
