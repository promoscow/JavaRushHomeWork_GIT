package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> array = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream iStream = new FileInputStream(reader.readLine());
        while (iStream.available() > 0)
        {
            array.add(iStream.read());
        }
        int[] array1 = new int[array.size()];           //переводим список в идентичный массив
        for (int i = 0; i < array.size(); i++)
        {
            array1[i] = array.get(i);
        }
        Arrays.sort(array1);
        System.out.print(array1[0] + " ");
        int x = array1[0];
        for (int i = 1; i < array1.length; i++)
        {
            if (array1[i] != x) {
                System.out.print(array1[i] + " ");
                x = array1[i];
            }
        }
        iStream.close();
    }
}
