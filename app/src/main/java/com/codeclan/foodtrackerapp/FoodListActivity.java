package com.codeclan.foodtrackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {

    Button newDiaryEntry;
    TextView newDay;
    TextView newMonth;
    TextView newMeal;
    TextView newFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        FoodList foodList = new FoodList();
        ArrayList<FoodItem> list = foodList.getList();

        FoodListAdapter foodListAdapter = new FoodListAdapter(this,list);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(foodListAdapter);

        newDiaryEntry = (Button)findViewById(R.id.button);



    }

    public void setNewEntryButtonClicked(View button){
        Intent intent = new Intent(this, AddFoodItemActivity.class);
        startActivity(intent);
    }



}
