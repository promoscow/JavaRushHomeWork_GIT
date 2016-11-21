package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("0", "ноль");
        map.put("1", "один");
        map.put("2", "два");
        map.put("3", "три");
        map.put("4", "четыре");
        map.put("5", "пять");
        map.put("6", "шесть");
        map.put("7", "семь");
        map.put("8", "восемь");
        map.put("9", "девять");
        map.put("10", "десять");
        map.put("11", "одиннадцать");
        map.put("12", "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine()), StandardCharsets.UTF_8));
        String line;
        while ((line = bufferedReader.readLine()) != null) System.out.println(lineCheck(line));
        scanner.close();
        bufferedReader.close();
    }

    private static String lineCheck(String line) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.printf("%s / %s : %s%n", entry.getKey(), entry.getValue(), line);
//            System.out.println("changed: " + line.replaceAll(entry.getKey(), entry.getValue()));
            line = line.replaceAll((entry.getKey()), entry.getValue());
        }
//        System.out.println("final: " + line);
        return line;
    }
}
