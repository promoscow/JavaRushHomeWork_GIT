package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[5];//массив

        for (int i = 0; i < a.length; i++)
        {
            a[i] = Integer.parseInt(reader.readLine());//вводим 5 чисел
        }

        for (int i = 0; i < a.length; i++)//большой цикл, в котором будем назначать новые значения массива
        {
            int min = a[i];//назначаем следующее число по списку минимальным
            int s = i;//назначаем номер ячейки массива, которую будем переназначать

            for (int j = i + 1; j < a.length; j++)//цикл от следующего номера ячейки до конца
            {
                if (min > a[j])
                {
                    min = a[j];//если обнаружили число меньше первого, то делаем min первым числом, а s у нас номер этого числа
                    s = j;
                }
            }
            if (i != s)//если номер номер ячейки был изменён, значит, число меньше было найдено
            {
                int tmp = a[i];//меняем местами числа в массиве через временную переменную temp
                a[i] = a[s];
                a[s] = tmp;
            }
        }
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
}