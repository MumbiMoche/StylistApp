package com.example.thestylist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        /*if(savedInstanceState == null){
            Intent intent =  new Intent(MainActivity.this, GirlsActivity.class);
            startActivity(intent);
        }*/

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        LayoutAdapter layoutAdapter = new LayoutAdapter(this, images, names, prices);
        recyclerView.setAdapter(layoutAdapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.young_girls:
                Intent intent =  new Intent(MainActivity.this, GirlsActivity.class);
                startActivity(intent);
                break;

            case R.id.young_boys:
                Intent intent_boys =  new Intent(MainActivity.this, BoysActivity.class);
                startActivity(intent_boys);
                break;

            case R.id.ladies:
                Intent intent_ladies =  new Intent(MainActivity.this, LadiesActivity.class);
                startActivity(intent_ladies);
                break;

            case R.id.men:
                Intent intent_men =  new Intent(MainActivity.this, MenActivity.class);
                startActivity(intent_men);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}