package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by user on 19/03/2017.
 */

public class FoodList extends AppCompatActivity {

    public static final String FOODLIST = "foodList";

    ArrayList<FoodItem> list;

    public FoodList() {
        list = new ArrayList<FoodItem>();
        list.add(new FoodItem("Stir Fry", "Supper", "19", "March"));
        list.add(new FoodItem("Tomato Soup", "Lunch", "19", "March"));
        list.add(new FoodItem("Porridge", "Breakfast", "19", "March"));
    }

    public ArrayList<FoodItem> getList() {
        return new ArrayList<FoodItem>(list);
    }

    public void addNewFoodItem(FoodItem foodItem) {
        list.add(foodItem);
    }

    public void deleteFoodItem(FoodItem foodItem){
        list.remove(foodItem);
    }

}
