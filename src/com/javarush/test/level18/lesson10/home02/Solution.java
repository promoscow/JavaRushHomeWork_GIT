package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream(args[0]);
        int breaks = 0;
        int count = 0;
        while(reader.available() > 0) {
            String a = Character.toString((char)reader.read());         //считываем байты, потом их в char, потом их в string
            if (matchBreaks(a)) breaks++;
            count++;
        }
        double dif = ((double) breaks / (double) count ) * 100;
        System.out.println(String.format("%.2f", dif));
        reader.close();
    }
    private static boolean matchBreaks(String a) {
        Pattern p = Pattern.compile("^ $");
        Matcher m = p.matcher(a);
        return m.matches();
    }
}
