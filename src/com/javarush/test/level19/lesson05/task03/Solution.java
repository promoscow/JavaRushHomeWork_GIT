package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        FileReader reader = new FileReader(scanner.nextLine());
        FileWriter writer = new FileWriter(scanner.nextLine());
        StringBuilder builder = new StringBuilder();
        while(reader.ready()) {
            char data = (char) reader.read();
            builder.append(data);
        }
        StringTokenizer st = new StringTokenizer(builder.toString().trim(), " ,./!:;-?");
        String[] words = new String[st.countTokens()];
        int count = 0;
        while(st.hasMoreTokens()) {
            words[count++] = st.nextToken();
        }
        StringBuilder builder1 = new StringBuilder();
        for (String word : words) {
            if (isDigitMatcher(word)) {
                builder1.append(word);
                builder1.append(" ");
            }
        }
        String output = builder1.toString().trim();
        char[] outChars = output.toCharArray();
        for (char outChar : outChars) {
            writer.write((int) outChar);
        }
        scanner.close();
        reader.close();
        writer.close();
    }

    private static boolean isDigitMatcher(String word) {
        char[] ch = word.toCharArray();
        for (char c : ch) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
