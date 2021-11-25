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
        extends RecyclerView.Adapter<RestaurantTypeAdapter.RestaurantTypeHolder> {

    private final RestaurantType[] restaurantTypes;

    public RestaurantTypeAdapter() {
        restaurantTypes = RestaurantType.values();
    }

    @NonNull
    @Override
    public RestaurantTypeHolder onCreateViewHolder(@NonNull ViewGroup p, int type) {
        LayoutInflater in = LayoutInflater.from(p.getContext());
        View view = in.inflate(R.layout.restaurant_type_view, p, false);
        return new RestaurantTypeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantTypeHolder holder, int i) {
        holder.setType(restaurantTypes[i]);
    }

    @Override
    public int getItemCount() { return restaurantTypes.length; }

    public static class RestaurantTypeHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private RestaurantType type;
        private final Button restaurantTypeButton;

        public RestaurantTypeHolder(@NonNull View view) {
            super(view);
            restaurantTypeButton = view.findViewById(R.id.restaurantTypeButton);
            restaurantTypeButton.setOnClickListener(this);
        }

        public void setType(RestaurantType type) {
            this.type = type;
            restaurantTypeButton.setText(type.name());
            restaurantTypeButton.setBackgroundColor(type.getColorFrom(itemView));
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
