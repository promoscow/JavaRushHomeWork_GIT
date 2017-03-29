package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

/**
 * Created by promoscow on 21.02.17.
 */
class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] digits = ConsoleHelper.getValidTwoDigits();
        manipulator.addAmount(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));
    }
}
