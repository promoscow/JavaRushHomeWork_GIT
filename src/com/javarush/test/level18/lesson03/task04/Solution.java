package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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
            for (Integer anArray : array)
            {
                if (Objects.equals(array.get(i), anArray)) count++;            //альтернативное сравнение
            }
            repeats[i] = count;
        }
        int min = findMinRepeat(repeats);
        ArrayList<Integer> equalMins = new ArrayList<>();           //в этот список заносим числа, которые уже были выведены на экран
        int[] array1 = new int[array.size()];           //переводим список в идентичный массив
        for (int i = 0; i < array.size(); i++)
        {
            array1[i] = array.get(i);
        }
        for (int z = 0; z < repeats.length; z++) {      //запуск массива значений
            if (repeats[z] == min) {        //число повторений соответствует минимуму
                boolean x = true;       //переключатель публиковали — не публиковали
                for (Integer equalInt : equalMins)      //пробегаем числом по массиву уже введённых чисел
                {
                    if (equalInt == repeats[z]) x = false;      //если это число уже было введено, переключаем
                }
                if (x) {        //если переключатель не был переключён (число не было введено)
                    equalMins.add(array1[z]);      //заносим число и печатаем его
                    System.out.print(array1[z] + " ");
                }
            }
        }

        iStream.close();
    }


    private static int findMinRepeat(int[] repeats)
    {
        int min = repeats[0];
        for (int i = 0; i < repeats.length; i++)
        {
            if (min > repeats[i]) min = repeats[i];
        }
        return min;
    }
}
