package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

/**
 * Created by promoscow on 21.02.17.
 */
class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] digits = ConsoleHelper.getValidTwoDigits();
        manipulator.addAmount(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),
                Integer.parseInt(digits[0]) * Integer.parseInt(digits[1]), currencyCode));
    }
}
