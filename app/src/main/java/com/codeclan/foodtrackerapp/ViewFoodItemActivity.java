package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ViewFoodItemActivity extends AppCompatActivity {

    TextView itemMeal;
    TextView itemFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_food_item);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String input_meal = extras.getString("foodItemMeal");
        String input_food = extras.getString("foodItemFood");

        itemMeal = (TextView)findViewById(R.id.item_meal);
        itemMeal.setText(input_meal);


        itemFood = (TextView)findViewById(R.id.item_food);
        itemFood.setText(input_food);

    }

}
