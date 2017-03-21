package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FoodListActivity extends AppCompatActivity {

    public static final String FOODLIST = "foodList";

    Button newDiaryEntry;
    ArrayList<FoodItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        Gson gson = new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences(FOODLIST, Context.MODE_PRIVATE);

        String listAsString = sharedPreferences.getString("foodList", "whatever");

        TypeToken<ArrayList<FoodItem>> typeNewFoodListArray = new TypeToken<ArrayList<FoodItem>>(){};
        ArrayList<FoodItem> list = gson.fromJson(listAsString,typeNewFoodListArray.getType());

        Collections.sort(list, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem foodItem, FoodItem t1) {
                return 0;
            }
        });

        FoodListAdapter foodListAdapter = new FoodListAdapter(this,list);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(foodListAdapter);

        newDiaryEntry = (Button)findViewById(R.id.button);
    }

    public void setNewEntryButtonClicked(View button){
        Intent intent = new Intent(this, AddFoodItemActivity.class);
        startActivity(intent);
    }

    public void onFoodItemClicked(View textView){
        TextView meal = (TextView) textView;
        FoodItem foodItem = (FoodItem) textView.getTag();

        Intent intent = new Intent(this, ViewFoodItemActivity.class);

        intent.putExtra("foodItem", foodItem);

        startActivity(intent);
    }

    public void setDeleteButtonClicked(View textView){

        TextView meal = (TextView) textView;
        FoodItem foodItem = (FoodItem) textView.getTag();

        list.remove(foodItem);

        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);
    }

}
