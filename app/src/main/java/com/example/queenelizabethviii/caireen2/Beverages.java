package com.example.queenelizabethviii.caireen2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class Beverages extends AppCompatActivity {

    ListView lst;
    String[] name = {"Coca Cola", "Fanta 3-Pack", "Fanta Bottled", "Moringa Tea"};
    Integer[] desc = {100, 200, 250, 100};
    Integer[] imgid = {R.drawable.beverages1, R.drawable.beverages2, R.drawable.beverages3, R.drawable.beverages4};
    Integer[] itemid = {11, 12, 13, 14};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lst = (ListView) findViewById(R.id.listbev);
        CustomListView customListView = new CustomListView(this,name,desc,imgid, itemid);
        lst.setAdapter(customListView);

    }

}
