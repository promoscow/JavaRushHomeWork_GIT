package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.*;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;

/**
 * Created by promoscow on 22.02.17.
 */
public class Tablet {
    private final int number;

    public Tablet(int number) {
        this.number = number;
    }
    public void createOrder() throws IOException {
        Order order = new Order();
        ConsoleHelper.writeMessage(order.toString());
    }
}
