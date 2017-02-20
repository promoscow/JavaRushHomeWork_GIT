package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by promoscow on 20.02.17.
 */
public class CurrencyManipulator {
    private String currencyCode;
    public static Map<Integer, Integer> denominations;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
