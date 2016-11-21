package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine()), StandardCharsets.UTF_8));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            char[] ch = line.toCharArray();
            for (int i = ch.length - 1; i >= 0 ; i--) {
                System.out.print(ch[i]);
            }
            System.out.println("");
        }
        scanner.close();
        bufferedReader.close();
    }
}
