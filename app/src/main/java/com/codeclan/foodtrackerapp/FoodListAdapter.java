package com.codeclan.foodtrackerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 19/03/2017.
 */

public class FoodListAdapter extends ArrayAdapter<FoodItem> {

    public FoodListAdapter(Context context, ArrayList<FoodItem> list){
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);

        }

        FoodItem currentFoodItem = getItem(position);

        TextView food = (TextView) listItemView.findViewById(R.id.food);
        food.setText(currentFoodItem.getFood().toString());

        return listItemView;

    }

}