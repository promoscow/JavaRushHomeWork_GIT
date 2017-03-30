package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by promoscow on 30.03.17.
 */
public class LoginCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String number = "123456789012";
        String pin = "1234";

        while (true) {
            ConsoleHelper.writeMessage("ВВЕДИТЕ НОМЕР КАРТЫ (12 чисел).");
            String cardNum = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("ВВЕДИТЕ PIN.");
            String enterPin = ConsoleHelper.readString();
            if (cardNum.length() != 12) {
                ConsoleHelper.writeMessage("НОМЕР КАРТЫ ДОЛЖЕН СОДЕРЖАТЬ 12 ЦИФР.");
                continue;
            }
            try {
                long checkNum = Long.parseLong(cardNum);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("НОМЕР КАРТЫ ДОЛЖЕН СОДЕРЖАТЬ 12 ЦИФР.");
                continue;
            }
            if (enterPin.length() != 4) {
                ConsoleHelper.writeMessage("PIN ДОЛЖЕН СОДЕРЖАТЬ 4 ЦИФРЫ.");
                continue;
            }
            try {
                int checkPin = Integer.parseInt(enterPin);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("PIN ДОЛЖЕН СОДЕРЖАТЬ 4 ЦИФРЫ.");
                continue;
            }
            if (number.equals(cardNum) && pin.equals(enterPin)) {
                ConsoleHelper.writeMessage("ДАННЫЕ ВЕРНЫ.");
                break;
            } else ConsoleHelper.writeMessage("ДАННЫЕ НЕ ВЕРНЫ. ПОПРОБУЙТЕ ЕЩЁ РАЗ.");
        }
    }
}
