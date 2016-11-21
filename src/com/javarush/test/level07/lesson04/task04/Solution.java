package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception

            /* задачу можно было решить намного компактнее, но условия задачи таковы... */
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[10];//создали массив 1

        for (int i = 0; i < a.length; i++)
        {
            a[i] = Integer.parseInt(reader.readLine());//записали в него значения
        }

        int[] s = new int[10];//создали вспомогательный массив 2
        for (int i = 0; i < a.length; i++)
        {
            s[i] = a[9 - i];//записали в него значения массива 1 в обратном порядке
        }

        for (int i = 0; i < a.length; i++)
        {
            a[i] = s[i];//переписали значения из массива 2 в массив 1
        }

        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);//вывели на экран значения массива 1
        }

    }
}
