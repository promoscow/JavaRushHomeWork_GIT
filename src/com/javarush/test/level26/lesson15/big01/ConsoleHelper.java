package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by promoscow on 20.02.17.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {

        String s = null;
        try {
            s = reader.readLine();
            if (s.toLowerCase().equals("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = "";
        while (true) {
            currencyCode = readString();
            if (currencyCode.matches("^[a-zA-Z]{3}$")) break;
            writeMessage(res.getString("invalid.data"));
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits() throws InterruptOperationException {
        writeMessage(res.getString("choose.denomination.and.count.format"));
        String enter = "";
        while (true) {
            enter = readString();
            if (enter.matches("\\d+ \\d+")) break;
            writeMessage(res.getString("invalid.data"));
        }
        return enter.split(" ");
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation = null;
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage(String.format("%s (1) %s (2) %s (3) %s (4)",
                    res.getString("operation.INFO"),
                    res.getString("operation.DEPOSIT"),
                    res.getString("operation.WITHDRAW"),
                    res.getString("operation.EXIT")));
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
                break;
            } catch (Exception e) {
                writeMessage(res.getString("wrong.input"));
            }
        }
        return operation;
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
