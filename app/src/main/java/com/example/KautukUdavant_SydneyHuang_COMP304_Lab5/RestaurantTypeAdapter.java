package com.example.KautukUdavant_SydneyHuang_COMP304_Lab5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kautukudavant_sydneyhuang_comp304_lab5.R;

public class RestaurantTypeAdapter
        extends RecyclerView.Adapter<RestaurantTypeAdapter.LandmarkTypeHolder> {

    private final RestaurantType[] restaurantTypes;

    public RestaurantTypeAdapter() {
        restaurantTypes = RestaurantType.values();
    }

    @NonNull
    @Override
    public LandmarkTypeHolder onCreateViewHolder(@NonNull ViewGroup p, int type) {
        LayoutInflater in = LayoutInflater.from(p.getContext());
        View view = in.inflate(R.layout.restaurant_type_view, p, false);
        return new LandmarkTypeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkTypeHolder holder, int i) {
        holder.setType(restaurantTypes[i]);
    }

    @Override
    public int getItemCount() { return restaurantTypes.length; }

    public static class LandmarkTypeHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private RestaurantType type;
        private final Button landmarkTypeButton;

        public LandmarkTypeHolder(@NonNull View view) {
            super(view);
            landmarkTypeButton = view.findViewById(R.id.landmarkTypeButton);
            landmarkTypeButton.setOnClickListener(this);
        }

        public void setType(RestaurantType type) {
            this.type = type;
            landmarkTypeButton.setText(type.name());
            landmarkTypeButton.setBackgroundColor(type.getColorFrom(itemView));
        }

        @Override
        public void onClick(View v) {
            Context ctx = v.getContext();
            Intent in = new Intent(ctx, RestaurantsActivity.class);
            in.putExtra(Restaurants.TYPE_EXTRA, type.toString());
            ctx.startActivity(in);
        }
    }
}
