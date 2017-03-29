package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by promoscow on 20.02.17.
 */
public class ConsoleHelper {

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
        writeMessage("ВВЕДИТЕ КОД ВАЛЮТЫ:");
        String currencyCode = "";
        while (true) {
            currencyCode = readString();
            if (currencyCode.matches("^[a-zA-Z]{3}$")) break;
            writeMessage("КОД ВАЛЮТЫ МОЖЕТ СОДЕРЖАТЬ 3 СИМВОЛА АНГЛИЙСКОГО АЛФАВИТА. ПОПРОБУЙТЕ ЕЩЁ РАЗ.");
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits() throws InterruptOperationException {
        writeMessage("ВВЕДИТЕ НОМИНАЛ И КОЛИЧЕСТВО БАНКНОТ (ЧЕРЕЗ ПРОБЕЛ):");
        String enter = "";
        while (true) {
            enter = readString();
            if (enter.matches("\\d+ \\d+")) break;
            writeMessage("НЕКОРРЕКТНЫЙ ВВОД. ВВЕДИТЕ НОМИНАЛ И КОЛ-ВО ВАЛЮТ.");
        }
        return enter.split(" ");
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation = null;
        while (true) {
            writeMessage("ВВЕДИТЕ КОД ОПЕРАЦИИ.");
            writeMessage("| INFO - 1 | DEPOSIT — 2 | WITHDRAW - 3 | EXIT - 4 |");
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
                break;
            } catch (Exception e) {
                writeMessage("ДАННЫЕ НЕ ВЕРНЫ. ПОПРОБУЙТЕ ЕЩЁ РАЗ.");
            }
        }
        return operation;
    }
}
