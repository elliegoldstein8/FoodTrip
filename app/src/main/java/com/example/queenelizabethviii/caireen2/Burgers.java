package com.example.queenelizabethviii.caireen2;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Burgers extends AppCompatActivity {

    ListView lst;
    String[] burgername = {"Burger Fries", "Burger Sandwich", "Jumbo Burger"};
    Integer[] burgerdesc = {100, 200, 250};
    Integer[] imgid = {R.drawable.burger1, R.drawable.burger2, R.drawable.burger3};
    Integer[] itemid = {121, 122, 123};
    ArrayList<String> keysList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burgers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.burg_toolbar);
        setSupportActionBar(toolbar);

       lst = (ListView) findViewById(R.id.dynamiclist);
       CustomListView customListView = new CustomListView(this,burgername,burgerdesc,imgid, itemid);
       lst.setAdapter(customListView);

       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               final String key = keysList.get(position);

           }
       });


    }

}
