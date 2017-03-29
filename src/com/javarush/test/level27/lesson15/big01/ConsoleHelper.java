package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by promoscow on 28.02.17.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String s = "";
        s = reader.readLine();
        return s;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        writeMessage("Please choose dishes: " + Dish.allDishesToString());
        String s = "";
        while (true) {
            s = reader.readLine();
            if (s.equals("exit")) return list;
            list.add(Dish.valueOf(s));
        }
    }
}
