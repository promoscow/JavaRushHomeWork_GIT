package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by promoscow on 30.03.17.
 */
public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNum = ConsoleHelper.readString();
            String enterPin = ConsoleHelper.readString();
            if (cardNum.length() != 12) {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
            try {
                long checkNum = Long.parseLong(cardNum);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
            if (enterPin.length() != 4) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            try {
                int checkPin = Integer.parseInt(enterPin);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (validCreditCards.containsKey(cardNum) && validCreditCards.getString(cardNum).equals(enterPin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNum));
                break;
            } else ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNum));
        }
    }
}
