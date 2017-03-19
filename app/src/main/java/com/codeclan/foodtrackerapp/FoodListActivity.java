package com.codeclan.foodtrackerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        FoodList foodList = new FoodList();
        ArrayList<FoodItem> list = foodList.getList();

        FoodListAdapter foodListAdapter = new FoodListAdapter(this,list);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(foodListAdapter);

    }
}
