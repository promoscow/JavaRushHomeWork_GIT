package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(firstFile);
        ArrayList<Integer> buffer = new ArrayList<>();
        while(inputStream1.available() > 0) {
            int firstFileData = inputStream1.read();
            buffer.add(firstFileData);
        }
        FileOutputStream outputStream = new FileOutputStream(firstFile);
        FileInputStream inputStream2 = new FileInputStream(secondFile);
        while(inputStream2.available() > 0) {           //переписываем содержимое второго файла в первый
            int secondFileData = inputStream2.read();
            outputStream.write(secondFileData);
        }
        FileOutputStream outputStream2 = new FileOutputStream(firstFile, true);
        for (Integer integer : buffer)
        {
            outputStream2.write(integer);
        }
        reader.close();
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
        outputStream2.close();
    }
}
