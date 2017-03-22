package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String input = extras.getString("input");

        if (input.equals("January")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("January")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        if (input.equals("February")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("February")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        if (input.equals("March")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("March")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("April")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("April")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("May")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("May")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("June")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("June")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("July")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("July")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("August")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("August")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("September")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("September")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("October")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("October")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("November")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("November")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        else if (input.equals("December")) {
            for (int i = 0; i < newFoodListArray.size(); i++) {
                if (!newFoodListArray.get(i).getMonth().equals("December")) {
                    objectsToRemove.add(newFoodListArray.get(i));
                }
            }

            for (FoodItem foodItem : objectsToRemove) {
                newFoodListArray.remove(foodItem);
            }
        }

        FoodListAdapter foodListAdapter = new FoodListAdapter(this,newFoodListArray);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(foodListAdapter);
    }

    public void setDeleteButtonClicked(View button){
        int foodItemPosition = (int) button.getTag();

        SharedPreferences sharedPreferences = getSharedPreferences(FOODLIST, Context.MODE_PRIVATE);
        String listAsString = sharedPreferences.getString("foodList", "whatever");

        Gson gson = new Gson();

        TypeToken<ArrayList<FoodItem>>typeNewFoodListArray = new TypeToken<ArrayList<FoodItem>>(){};
        ArrayList<FoodItem>newFoodListArray = gson.fromJson(listAsString,typeNewFoodListArray.getType());

//        Log.d("Before adding item", String.valueOf(newFoodListArray.size()));
        newFoodListArray.remove(foodItemPosition);
//        Log.d("Remove item", String.valueOf(newFoodListArray.size()));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("foodList", gson.toJson(newFoodListArray));
        editor.apply();

        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);
    }

    public void setAllButtonClicked(View button){
        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);
    }

}
