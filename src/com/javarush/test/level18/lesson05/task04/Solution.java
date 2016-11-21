package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1Name);
        FileOutputStream outputStream = new FileOutputStream(file2Name);
        ArrayList<Integer> array = new ArrayList<>();
        while(inputStream.available() > 0) {
            array.add(inputStream.read());
        }
        for (int i = (array.size() - 1); i >= 0; i--)
        {
            outputStream.write(array.get(i));
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
