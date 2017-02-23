package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by promoscow on 20.02.17.
 */
public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException, NotEnoughMoneyException {

        String s = "";
        try {
            s = reader.readLine();
        } catch (IOException e) {

        }
        return s;
    }

    public static String askCurrencyCode() throws NotEnoughMoneyException, InterruptOperationException {
        writeMessage("ВВЕДИТЕ КОД ВАЛЮТЫ:");
        String currencyCode = "";
        while (true) {
            currencyCode = readString();
            if (isCorrectCurrency(currencyCode)) break;
            writeMessage("КОД ВАЛЮТЫ МОЖЕТ СОДЕРЖАТЬ 3 СИМВОЛА АНГЛИЙСКОГО АЛФАВИТА. ПОПРОБУЙТЕ ЕЩЁ РАЗ.");
        }
        return currencyCode.toUpperCase();
    }

    private static boolean isCorrectCurrency(String newNickname) {
        Pattern p = Pattern.compile("^[a-zA-Z]{3}$");
        Matcher m = p.matcher(newNickname);
        return m.matches();
    }

    public static String[] getValidTwoDigits() throws NotEnoughMoneyException, InterruptOperationException {
        writeMessage("ВВЕДИТЕ НОМИНАЛ И КОЛИЧЕСТВО БАНКНОТ (ЧЕРЕЗ ПРОБЕЛ):");
        String enter = "";
        while (true) {
            enter = readString();
            if (enter.matches("\\d+ \\d+")) break;
            writeMessage("НЕКОРРЕКТНЫЙ ВВОД. ВВЕДИТЕ НОМИНАЛ И КОЛ-ВО ВАЛЮТ.");
        }
        return enter.split(" ");
    }

    public static Operation askOperation() throws NotEnoughMoneyException, InterruptOperationException {
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
