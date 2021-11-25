package com.example.KautukUdavant_SydneyHuang_COMP304_Lab5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kautukudavant_sydneyhuang_comp304_lab5.R;


public class RestaurantsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RestaurantType restaurantType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        getTypeFromIntent();
    }

    private void getTypeFromIntent() {
        Intent in = getIntent();
        String str = in.getStringExtra(Restaurants.TYPE_EXTRA);
        if (str == null) finish();
        restaurantType = RestaurantType.valueOf(str);
        setTitle(restaurantType.name());
        initRecycler();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.restaurantRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RestaurantAdapter adapter = new RestaurantAdapter(
                Restaurants.getRestaurantByType(restaurantType, true));
        recyclerView.setAdapter(adapter);
    }
}