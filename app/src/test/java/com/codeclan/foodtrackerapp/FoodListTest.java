package com.codeclan.foodtrackerapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 19/03/2017.
 */

public class FoodListTest {

    @Test
    public void getListTest() {
        FoodList foodList = new FoodList();
        assertEquals(3, foodList.getList().size());
    }

}
