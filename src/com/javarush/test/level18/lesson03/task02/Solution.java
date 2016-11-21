package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> array = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream iStream = new FileInputStream(reader.readLine());
        while (iStream.available() > 0)
        {
            array.add(iStream.read());
        }
        int min = array.get(0);
        for (Integer aByte : array)
        {
            if (aByte < min) min = aByte;
        }
        System.out.println(min);
        iStream.close();
    }
}
