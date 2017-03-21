package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MonthlyActivity extends AppCompatActivity {

    public static final String FOODLIST = "foodList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        Gson gson = new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences(FOODLIST, Context.MODE_PRIVATE);
        String listAsString = sharedPreferences.getString("foodList", "whatever");

        TypeToken<ArrayList<FoodItem>>typeNewFoodListArray = new TypeToken<ArrayList<FoodItem>>(){};
        ArrayList<FoodItem>newFoodListArray = gson.fromJson(listAsString,typeNewFoodListArray.getType());

        ArrayList<FoodItem>objectsToRemove = new ArrayList<>();

        for (int i=0; i<newFoodListArray.size(); i++){
            if (!newFoodListArray.get(i).getMonth().equals("March")){
               objectsToRemove.add(newFoodListArray.get(i));
            }
        }

        for (FoodItem foodItem : objectsToRemove){
            newFoodListArray.remove(foodItem);
        }

        FoodListAdapter foodListAdapter = new FoodListAdapter(this,newFoodListArray);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(foodListAdapter);
    }
}
