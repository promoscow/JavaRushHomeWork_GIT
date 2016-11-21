package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
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
        int[] repeats = new int[array.size()];
        for (int i = 0; i < array.size(); i++)
        {
            int count = 0;
            for (int j = 0; j <array.size() ; j++)
            {
                if (Objects.equals(array.get(i), array.get(j))) count++;            //альтернативное сравнение
            }
            repeats[i] = count;
        }
        int max = findMax(repeats);
        ArrayList<Integer> equalInts = new ArrayList<>();           //в этот список заносим числа, которые уже были выведены на экран
        int[] array1 = new int[array.size()];
        for (int i = 0; i < array.size(); i++)
        {
            array1[i] = array.get(i);
        }
        for (int i = 0; i < repeats.length; i++)            //запускаем цикл, который будет проверять, то ли это максимальное число, или нет, и выводит его значение на экран
        {
            if (repeats[i] == max) {            //если это тот самый максимум (14)
                boolean b = true;           //было или не было число
                for (Integer equalInt : equalInts)          //мы должны проверить, не выводили ли мы это самое число уже, массив equalInt содержит числа, которые мы уже выводили
                {
                    if (equalInt == repeats[i]) b = false;
                }
                if (b) {
                    equalInts.add(repeats[i]);
                    System.out.println(array1[i] + " ");
                }
            }
        }
    }

    private static int findMax(int[] repeats)
    {
        int max = 0;
        for (int i = 0; i < repeats.length; i++)
        {
            if (max < repeats[i]) max = repeats[i];
        }
        return max;
    }
}
