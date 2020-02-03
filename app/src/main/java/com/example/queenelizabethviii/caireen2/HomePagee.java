package com.example.queenelizabethviii.caireen2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.view.Menu;
import android.view.MenuItem;

public class HomePagee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pagee);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton burger = findViewById(R.id.burger_button);
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBurgers();
            }
        });

        ImageButton beverages = findViewById(R.id.bev_button);
        beverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBeverages();
            }
        });

        ImageButton combo = findViewById(R.id.combo_button);
        combo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCombo();
            }
        });

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
    }


    public void openBurgers(){
        Intent intent = new Intent(HomePagee.this, Burgers.class);
        startActivity(intent);
    }

    public void openBeverages(){
        Intent intent = new Intent(HomePagee.this, Beverages.class);
        startActivity(intent);
    }

    public void openCombo(){
        Intent intent = new Intent(HomePagee.this, ComboMeals.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.checkout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.checkitem){
            Intent intent = new Intent(this, Checkout.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


}
