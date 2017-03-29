package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by promoscow on 21.02.17.
 */
public final class CommandExecutor {
    private static Map<Operation, Command> commands = new HashMap<>();

    static {
        commands.put(Operation.DEPOSIT, new DepositCommand());
        commands.put(Operation.EXIT, new ExitCommand());
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.WITHDRAW, new WithdrawCommand());
    }

    private CommandExecutor() {
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        if (commands.containsKey(operation)) {
            commands.get(operation).execute();
        }
    }
}
