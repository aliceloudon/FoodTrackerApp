package com.codeclan.foodtrackerapp;

import java.util.ArrayList;

/**
 * Created by user on 19/03/2017.
 */

public class FoodList {

    private ArrayList<FoodItem> list;

    public FoodList() {
        list = new ArrayList<FoodItem>();
        list.add(new FoodItem("Stir Fry", "Supper", "19 March 2017"));
        list.add(new FoodItem("Tomato Soup", "Lunch", "19 March 2017"));
        list.add(new FoodItem("Porridge", "Breakfast", "19 March 2017"));
    }

    public ArrayList<FoodItem> getList() {
        return new ArrayList<FoodItem>(list);
    }

}
