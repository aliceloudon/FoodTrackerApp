package com.codeclan.foodtrackerapp;

import java.io.Serializable;

/**
 * Created by user on 19/03/2017.
 */

public class FoodItem implements Serializable {

    private String food;
    private String meal;
    private String day;
    private String month;

    public FoodItem(String food, String meal, String day, String month) {
        this.food = food;
        this.meal = meal;
        this.day = day;
        this.month = month;

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
