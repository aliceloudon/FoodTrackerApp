package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import static android.R.id.input;

public class AddFoodItemActivity extends AppCompatActivity {

    public static final String FOODLIST = "foodList";

    EditText addDay;
    EditText addMonth;
    EditText addMeal;
    EditText addFood;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food_item);

        addDay = (EditText)findViewById(R.id.add_day);
        addMonth = (EditText)findViewById(R.id.add_month);
        addMeal = (EditText)findViewById(R.id.add_meal);
        addFood = (EditText)findViewById(R.id.add_food);
        saveButton = (Button)findViewById(R.id.save_button);
    }

    public void onSaveButtonClicked(View button) {
        String new_day = addDay.getText().toString();
        String new_month = addMonth.getText().toString();
        String new_meal = addMeal.getText().toString();
        String new_food = addFood.getText().toString();

        FoodItem foodItem = new FoodItem(new_food, new_meal, new_day, new_month);

        SharedPreferences sharedPreferences = getSharedPreferences(FOODLIST, Context.MODE_PRIVATE);
        String listAsString = sharedPreferences.getString("foodList", "whatever");

        Gson gson = new Gson();

        TypeToken<ArrayList<FoodItem>>typeNewFoodListArray = new TypeToken<ArrayList<FoodItem>>(){};
        ArrayList<FoodItem>newFoodListArray = gson.fromJson(listAsString,typeNewFoodListArray.getType());

        newFoodListArray.add(foodItem);




        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("foodList", gson.toJson(newFoodListArray));
        editor.apply();




        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);

    }

}
