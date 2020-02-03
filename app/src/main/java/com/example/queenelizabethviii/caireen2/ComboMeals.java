package com.example.queenelizabethviii.caireen2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class ComboMeals extends AppCompatActivity {

    ListView lst;
    String[] name = {"Maxi Combo", "Combo Punch", "Cucombo", "ComboNut"};
    Integer[] desc = {100, 200, 250, 100};
    Integer[] imgid = {R.drawable.combo1, R.drawable.combo2, R.drawable.combo3, R.drawable.combo4};
    Integer[] itemid = {111, 112, 113, 114};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_meals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lst = (ListView) findViewById(R.id.listcom);
        CustomListView customListView = new CustomListView(this,name,desc,imgid, itemid);
        lst.setAdapter(customListView);

    }

}
