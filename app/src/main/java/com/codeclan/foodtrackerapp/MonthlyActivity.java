package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyActivity extends AppCompatActivity {

    ArrayList<FoodItem> foodItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        foodItemList = Manager.getListFromSharedPreferences(this);

        ArrayList<FoodItem>objectsToRemove = new ArrayList<>();

        FoodListAdapter foodListAdapter = new FoodListAdapter(this, foodItemList);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(foodListAdapter);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        HashMap<String, Integer> input = extras.getString("input");


        if (input.equals("January")) {
            for (int i = 0; i < foodItemList.size(); i++) {
                if (!foodItemList.get(i).getMonth().equals("January")) {
                    objectsToRemove.add(foodItemList.get(i));
                }
            }
            for (FoodItem foodItem : objectsToRemove) {
                foodItemList.remove(foodItem);
            }
        }
    }

    public void setDeleteButtonClicked(View button){

        int foodItemPosition = (int) button.getTag();

        foodItemList = Manager.getListFromSharedPreferences(this);
        foodItemList.remove(foodItemPosition);

        Manager.saveListInSharedPreferences(this, foodItemList);

        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Item has been deleted!", Toast.LENGTH_LONG).show();
    }


    public void setAllButtonClicked(View button){
        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);
    }

}
