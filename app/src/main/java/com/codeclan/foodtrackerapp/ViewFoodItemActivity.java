package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ViewFoodItemActivity extends AppCompatActivity {

    public static final String FOODLIST = "foodList";
    TextView itemMeal;
    TextView itemFood;
    TextView itemDay;
    TextView itemMonth;
    FoodItem foodItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_food_item);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        foodItem = (FoodItem)extras.getSerializable("foodItem");

        String input_day = foodItem.getDay();
        String input_month = foodItem.getMonth();
        String input_meal = foodItem.getMeal();
        String input_food = foodItem.getFood();

        itemDay = (TextView)findViewById(R.id.item_day);
        itemDay.setText(input_day);

        itemMonth = (TextView)findViewById(R.id.item_month);
        itemMonth.setText(input_month);

        itemMeal = (TextView)findViewById(R.id.item_meal);
        itemMeal.setText(input_meal);

        itemFood = (TextView)findViewById(R.id.item_food);
        itemFood.setText(input_food);
    }
}
