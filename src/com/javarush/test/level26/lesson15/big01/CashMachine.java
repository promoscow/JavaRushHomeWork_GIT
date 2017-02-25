package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Locale;

/**
 * Created by promoscow on 20.02.17.
 */
public class CashMachine {
    public static void main(String[] args) throws NotEnoughMoneyException {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Operation operation = null;
            while (true) {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("ВСЕГО ХОРОШЕГО!");
        }
    }
}
