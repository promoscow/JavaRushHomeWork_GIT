package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;

/**
 * Created by promoscow on 21.02.17.
 */
class InfoCommand implements Command {
    @Override
    public void execute() {
        Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean hasMoney = false;
        for (CurrencyManipulator currencyManipulator : collection) {
            hasMoney = (currencyManipulator.hasMoney() && currencyManipulator.getTotalAmount() != 0 || hasMoney);
            if (currencyManipulator.getTotalAmount() != 0) {
                ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
            }
        }
        if (!hasMoney) ConsoleHelper.writeMessage("No money available.");
    }
}
