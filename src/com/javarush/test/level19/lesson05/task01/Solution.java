package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        FileReader reader = new FileReader(scanner.nextLine());
        FileWriter writer = new FileWriter(scanner.nextLine());
        ArrayList<Integer> bytes = new ArrayList<>();
        while (reader.ready()) { //пока есть непрочитанные байты в потоке ввода
            bytes.add(reader.read()); //читаем один символ (char будет расширен до int)
        }
        Integer[] x = bytes.toArray(new Integer[bytes.size()]);

        for (int i = 0; i < x.length; i++) {
            int a = x[i];
            if (i % 2 != 0) writer.write(a);
        }
        //закрываем потоки после использования
        reader.close();
        writer.close();
        scanner.close();
    }
}
