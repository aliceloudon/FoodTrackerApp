package com.codeclan.foodtrackerapp;

/**
 * Created by user on 19/03/2017.
 */

public class FoodItem {

    private String food;
    private String meal;
    private String date;

    public FoodItem(String food, String meal, String date) {
        this.food = food;
        this.meal = meal;
        this.date = date;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
