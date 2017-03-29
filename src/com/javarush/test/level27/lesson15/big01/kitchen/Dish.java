package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

/**
 * Created by promoscow on 22.02.17.
 */
public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        Dish[] dishes = Dish.values();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dishes.length; i++)
        {
            sb.append(dishes[i]);
            if (i != dishes.length - 1)
                sb.append(", ");
        }
        return sb.toString();
    }
}
