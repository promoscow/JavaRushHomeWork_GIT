package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        int x = 0;

        if (a1 > 0)
            z = z + 1;
        else if (a1 < 0)
            x = x + 1;
        if (a2 > 0)
            z = z + 1;
        else if (a2 < 0)
            x = x + 1;
        if (a3 > 0)
            z = z + 1;
        else if (a3 < 0)
            x = x + 1;

        System.out.println("количество отрицательных чисел: " + x);
        System.out.println("количество положительных чисел: " + z);

    }
}
