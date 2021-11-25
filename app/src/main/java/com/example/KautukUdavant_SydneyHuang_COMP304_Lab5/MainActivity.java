package com.example.KautukUdavant_SydneyHuang_COMP304_Lab5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kautukudavant_sydneyhuang_comp304_lab5.R;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();

    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.restaurantTypesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RestaurantTypeAdapter());
    }

}