package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by promoscow on 20.02.17.
 */
public class CurrencyManipulator {
    public Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();
    private String currencyCode = "";

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }

//        ArrayList<Integer> list = new ArrayList<>(denominations.keySet());
//        Collections.sort(list);
//        Collections.reverse(list);
//        for (Integer aList : list) {
//            ConsoleHelper.writeMessage("\t" + aList + " - " + denominations.get(aList));
//        }
    }

    public int getTotalAmount() {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) count += (entry.getKey() * entry.getValue());
        return count;
    }

    public boolean hasMoney() {
        return (!denominations.isEmpty());
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return this.getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>(denominations.keySet());
        Collections.sort(list);
        Collections.reverse(list);
        for (Integer integer : list) {    //integer - номинал
            int x = expectedAmount / integer;    //сколько купюр данного номинала требуется в идеале
//            System.out.println("expected: denomination - " + integer + ", amount - " + x);
//            System.out.println(denominations.get(integer) + " value");
            if (x > 0) {
                if (denominations.get(integer) >= x) {
                    map.put(integer, x);
                    expectedAmount -= integer * x;
                }
                else {
                    map.put(integer, denominations.get(integer));
                    expectedAmount -= denominations.get(integer) * integer;
                }
            }
            if (expectedAmount == 0) break;
        }
        if (expectedAmount > 0) {
            throw new NotEnoughMoneyException();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int m = denominations.get(entry.getKey());
            denominations.remove(entry.getKey());
            denominations.put(entry.getKey(), (m - entry.getValue()));
        }
        return map;
    }
}
