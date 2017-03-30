package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;

/**
 * Created by promoscow on 23.02.17.
 */
public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider();
        Controller controller = new Controller(provider);
        System.out.println(controller);
    }
}
