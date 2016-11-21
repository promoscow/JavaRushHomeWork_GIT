package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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
            if (data == '.') data = '!';
            int data1 = data;
            writer.write(data1); //пишем один символ (int будет обрезан/сужен до char)
        }

        //закрываем потоки после использования
        reader.close();
        writer.close();
        scanner.close();
    }
}
