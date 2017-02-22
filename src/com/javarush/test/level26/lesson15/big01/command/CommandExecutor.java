package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by promoscow on 21.02.17.
 */
public final class CommandExecutor {
    private static Map<Operation, Command> commands = new HashMap<>();

    private CommandExecutor() {
    }

    static {
        commands.put(Operation.DEPOSIT, new DepositCommand());
        commands.put(Operation.EXIT, new ExitCommand());
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.WITHDRAW, new WithdrawCommand());
    }

    public static final void execute(Operation operation) throws NotEnoughMoneyException, InterruptOperationException {
        if (commands.containsKey(operation)) {
            commands.get(operation).execute();
        }
    }
}
