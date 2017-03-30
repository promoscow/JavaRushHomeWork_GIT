package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by promoscow on 21.02.17.
 */
class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean hasMoney = false;
        for (CurrencyManipulator currencyManipulator : collection) {
            hasMoney = (currencyManipulator.hasMoney() && currencyManipulator.getTotalAmount() != 0 || hasMoney);
            if (currencyManipulator.getTotalAmount() != 0) {
                ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
            }
        }
        if (!hasMoney) ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
