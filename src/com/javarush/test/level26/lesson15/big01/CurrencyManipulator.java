package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level20.lesson02.task05.Solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by promoscow on 20.02.17.
 */
public class CurrencyManipulator {
    public Map<Integer, Integer> denominations = new HashMap<>();
    private String currencyCode;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if(denominations.containsKey(denomination)){
            denominations.put(denomination, denominations.get(denomination) + count);
        }else{
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) count += (entry.getKey() * entry.getValue());
        return count;
    }

    public boolean hasMoney() {
        return (!denominations.isEmpty());
    }
}
