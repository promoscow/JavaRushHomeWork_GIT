package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader reader = new FileReader(scanner.nextLine());
        FileWriter writer = new FileWriter(scanner.nextLine());
        while (reader.ready()) { //пока есть непрочитанные байты в потоке ввода
            char data = (char) reader.read(); //читаем один символ (char будет расширен до int)
            if (!matcher(data)) {
                int data1 = data;
                writer.write(data1); //пишем один символ (int будет обрезан/сужен до char)
            }
        }
        reader.close();
        writer.close();
        scanner.close();
    }

    private static boolean matcher(char c) {
        int x = c;
        for (int i = 33; i <= 47; i++) {
            if (i == x) return true;
        }
        for (int i = 58; i <= 63; i++) {
            if (i == x) return true;
        }
        for (int i = 91; i <= 96; i++) {
            if (i == x) return true;
        }
        for (int i = 123; i <= 126; i++) {
            if (i == x) return true;
        }
        if (c == '\n') return true;
        return false;
    }
}
