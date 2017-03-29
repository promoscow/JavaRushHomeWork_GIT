package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Locale;

/**
 * Created by promoscow on 20.02.17.
 */
public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

//        CurrencyManipulator manipulator = null;
//        String currencyCode = "RUR";
//        manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//        manipulator.addAmount(5000, 2);
//        manipulator.addAmount(1000, 1);
//        manipulator.addAmount(500, 3);
//        manipulator.addAmount(100, 2);
//        manipulator.addAmount(50, 3);

            Operation operation = null;
        try {
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("ВСЕГО ХОРОШЕГО.");
        }
    }
}
