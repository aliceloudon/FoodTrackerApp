package com.codeclan.foodtrackerapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 19/03/2017.
 */

public class FoodItemTest {

    FoodItem foodItem;

    @Before
    public void before() {
        foodItem = new FoodItem("Porridge", "Breakfast", "19 March 2017");
    }

    @Test
    public void getFoodTest() {
        assertEquals("Porridge", foodItem.getFood());

    }

    @Test
    public void getMealTest() {
        assertEquals("Breakfast", foodItem.getMeal());

    }

    @Test
    public void getDateTest() {
        assertEquals("19 March 2017", foodItem.getDate());

    }
    
}
