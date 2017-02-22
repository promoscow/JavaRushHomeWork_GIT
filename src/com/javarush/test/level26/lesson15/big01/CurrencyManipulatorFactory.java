package com.javarush.test.level26.lesson15.big01;

        import java.util.Collection;
        import java.util.HashMap;
        import java.util.Map;

/**
 * Created by promoscow on 20.02.17.
 */
public final class CurrencyManipulatorFactory {
    public static Map<String, CurrencyManipulator> manipulators = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {

        CurrencyManipulator result;
        if (manipulators.containsKey(currencyCode))
            result = manipulators.get(currencyCode);
        else {
            result = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, result);
        }
        return result;
    }


    public static Collection<CurrencyManipulator> getAllCurrencyManipulators () {
        return manipulators.values();
    }
}
