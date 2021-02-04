package com.example.thestylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import java.util.ArrayList;

public class MenActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boys);
        ArrayList<Integer> images = new ArrayList<>();

        images.add(R.drawable.men);
        images.add(R.drawable.men);
        images.add(R.drawable.men);
        images.add(R.drawable.men);
        images.add(R.drawable.men);
        images.add(R.drawable.men);
        images.add(R.drawable.men);
        images.add(R.drawable.men);

        ArrayList<String> names = new ArrayList<>();

        names.add("Girl Clothes");
        names.add("Girl Clothes");
        names.add("Girl Clothes");
        names.add("Girl Clothes");
        names.add("Girl Clothes");
        names.add("Girl Clothes");
        names.add("Girl Clothes");
        names.add("Girl Clothes");


        ArrayList<String> prices = new ArrayList<>();

        prices.add("1000");
        prices.add("1000");
        prices.add("1000");
        prices.add("1000");
        prices.add("1000");
        prices.add("1000");
        prices.add("1000");
        prices.add("1000");

        toolbar = findViewById(R.id.tool_bar_cart);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);

        recyclerView = findViewById(R.id.recycler_view_boys);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        BoysAdaptor boysAdaptor = new BoysAdaptor(this, images, names, prices);
        recyclerView.setAdapter(boysAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}