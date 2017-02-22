package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Locale;

/**
 * Created by promoscow on 20.02.17.
 */
public class CashMachine {
    public static void main(String[] args) throws InterruptOperationException, NotEnoughMoneyException {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        } while (!operation.equals(Operation.EXIT));
    }
}
