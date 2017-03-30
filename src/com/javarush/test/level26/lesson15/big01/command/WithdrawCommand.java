package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by promoscow on 21.02.17.
 */
class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        try {
            int amount = 0;
            while (true) {
                ConsoleHelper.writeMessage(res.getString("enter.amount"));
                try {
                    amount = Integer.parseInt(ConsoleHelper.readString());
                    if (!manipulator.isAmountAvailable(amount)) {
                        ConsoleHelper.writeMessage(res.getString("no.money"));
                        continue;
                    }
                    Map<Integer, Integer> map = manipulator.withdrawAmount(amount);
                    ArrayList<Integer> list = new ArrayList<>(map.keySet());
                    Collections.sort(list);
                    Collections.reverse(list);
                    for (int i = 0; i < list.size(); i++) {
                        ConsoleHelper.writeMessage("\t" + list.get(i) + " - " + map.get(list.get(i)));
                    }
                    ConsoleHelper.writeMessage(res.getString("operation.success"));
                    break;

                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("enter.digit"));
                }
            }
        } catch (NotEnoughMoneyException e) {
            ConsoleHelper.writeMessage(res.getString("no.denominations"));
        }
    }
}
