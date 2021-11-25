package com.example.KautukUdavant_SydneyHuang_COMP304_Lab5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kautukudavant_sydneyhuang_comp304_lab5.R;


public class LandmarksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LandmarkType landmarkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmarks);

        getTypeFromIntent();
    }

    private void getTypeFromIntent() {
        Intent in = getIntent();
        String str = in.getStringExtra(Landmarks.TYPE_EXTRA);
        if (str == null) finish();
        landmarkType = LandmarkType.valueOf(str);
        setTitle(landmarkType.format());
        initRecycler();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.landmarksRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        com.example.KautukUdavant_SydneyHuang_COMP304_Lab5.LandmarkAdapter adapter = new com.example.KautukUdavant_SydneyHuang_COMP304_Lab5.LandmarkAdapter(
                Landmarks.getLandmarksByType(landmarkType, true));
        recyclerView.setAdapter(adapter);
    }
}