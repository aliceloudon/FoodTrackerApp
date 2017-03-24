package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 24/03/2017.
 */

public class Manager {

    public static final String LIST = "foodList";

    public static ArrayList<FoodItem> getListFromSharedPreferences(Context context){

        SharedPreferences sharedPreferences = context.getSharedPreferences(LIST, Context.MODE_PRIVATE);
        String foodList = sharedPreferences.getString("foodList", "Nothing here");

        Gson gson = new Gson();
        TypeToken<ArrayList<FoodItem>> foodArrayList = new TypeToken<ArrayList<FoodItem>>(){};
        ArrayList<FoodItem> foodItemList = gson.fromJson(foodList, foodArrayList.getType());
        return foodItemList;
    }

    public static void saveListInSharedPreferences(Context context, ArrayList<FoodItem> foodItemList){

        // By making these methods static I can just call Manager.______ in FoodListActivity rather than having to make a new manager object each time.

        SharedPreferences sharedPreferences = context.getSharedPreferences(LIST, Context.MODE_PRIVATE);

        Gson gson = new Gson();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("foodList", gson.toJson(foodItemList));
        editor.apply();

    }

}
