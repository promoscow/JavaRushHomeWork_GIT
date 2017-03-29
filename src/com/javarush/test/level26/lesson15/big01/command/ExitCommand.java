package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

/**
 * Created by promoscow on 21.02.17.
 */
class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("ВЫ ДЕЙСТВИТЕЛЬНО ХОТИТЕ ВЫЙТИ? (Y / N)");
        String answer = ConsoleHelper.readString().toLowerCase();
        if (answer.equals("y")) ConsoleHelper.writeMessage("УДАЧИ!");
        else if (answer.equals("n")) {}
    }
}
