package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner;
        File x = new File(reader.readLine());
        scanner  = new Scanner(x);
        while (scanner.hasNext())
        {
            lines.add(scanner.next());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines)
        {
            stringBuilder.append(line);
        }
        char[] ch = stringBuilder.toString().toCharArray();
        int count = 0;
        for (char c : ch)
        {
            if(c == 44) count++;
        }
        System.out.println(count);
        scanner.close();
        reader.close();
    }
}
