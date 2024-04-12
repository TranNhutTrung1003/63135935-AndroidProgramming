package com.example.ntu.usingrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewLandScape;
    ArrayList<LandScape> dsLandScape;
    LandScapeAdapter landScapeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dsLandScape = getDataForRecyclerView();

        recyclerViewLandScape = findViewById(R.id.recyclerLand);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerViewLandScape.setLayoutManager(layoutManager);
//        RecyclerView.LayoutManager layoutManagerHorizonal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewLandScape.setLayoutManager(layoutManagerHorizonal);
        RecyclerView.LayoutManager layoutManagerGrid = new GridLayoutManager(this, 2);
        recyclerViewLandScape.setLayoutManager(layoutManagerGrid);

        landScapeAdapter = new LandScapeAdapter(this, dsLandScape);
        recyclerViewLandScape.setAdapter(landScapeAdapter);
    }

    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> landScapes = new ArrayList<LandScape>();
        landScapes.add(new LandScape("Hồ gươm, Hà nội", "hoguom"));
        landScapes.add(new LandScape("Tháp Eiffle", "eiffel"));
        landScapes.add(new LandScape("Tháp Tokyo", "thaptokyo"));
        landScapes.add(new LandScape("Tượng nữ thần tự do", "tuongnuthan"));
        return landScapes;
    }
}