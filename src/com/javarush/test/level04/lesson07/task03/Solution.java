package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String t1 = reader.readLine();
        int a1 = Integer.parseInt(t1);
        String t2 = reader.readLine();
        int a2 = Integer.parseInt(t2);
        String t3 = reader.readLine();
        int a3 = Integer.parseInt(t3);

        int z = 0;

        if (a1 > 0)
            z = z + 1;
        if (a2 > 0)
            z = z + 1;
        if (a3 > 0)
            z = z + 1;

        System.out.println(z);

    }
}
