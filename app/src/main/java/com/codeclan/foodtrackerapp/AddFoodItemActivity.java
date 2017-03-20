package com.codeclan.foodtrackerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.input;

public class AddFoodItemActivity extends AppCompatActivity {

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

        FoodList foodList = new FoodList();
        foodList.addNewFoodItem(foodItem);

        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);

    }

}
