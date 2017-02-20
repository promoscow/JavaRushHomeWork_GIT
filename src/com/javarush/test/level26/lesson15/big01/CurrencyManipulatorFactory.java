package com.javarush.test.level26.lesson15.big01;

/**
 * Created by promoscow on 20.02.17.
 */
public class CurrencyManipulatorFactory {
    private static CurrencyManipulatorFactory ourInstance = new CurrencyManipulatorFactory();

    public static CurrencyManipulatorFactory getInstance() {
        return ourInstance;
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (CurrencyManipulator.denominations.containsKey(currencyCode))
        return null;
    }

    private CurrencyManipulatorFactory() {
    }
}
