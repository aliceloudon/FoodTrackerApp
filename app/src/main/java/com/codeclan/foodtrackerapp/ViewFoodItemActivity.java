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
    FoodItem foodItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_food_item);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        foodItem = (FoodItem)extras.getSerializable("foodItem");

        String input_meal = foodItem.getMeal();
        String input_food = foodItem.getFood();

        itemMeal = (TextView)findViewById(R.id.item_meal);
        itemMeal.setText(input_meal);

        itemFood = (TextView)findViewById(R.id.item_food);
        itemFood.setText(input_food);
    }

    public void onDeleteButtonClicked(View button){

        SharedPreferences sharedPreferences = getSharedPreferences(FOODLIST, Context.MODE_PRIVATE);
        String listAsString = sharedPreferences.getString("foodList", "whatever");

        Gson gson = new Gson();

        TypeToken<ArrayList<FoodItem>>typeNewFoodListArray = new TypeToken<ArrayList<FoodItem>>(){};
        ArrayList<FoodItem>newFoodListArray = gson.fromJson(listAsString,typeNewFoodListArray.getType());

        newFoodListArray.remove(foodItem);
        Log.d("Food item removed", String.valueOf(newFoodListArray.size()));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("foodList", gson.toJson(newFoodListArray));
        editor.apply();

        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);
    }

}
