package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String t = reader.readLine();
        int a = Integer.parseInt(t);
        String t1 = reader.readLine();
        int a1 = Integer.parseInt(t1);

        if (a > a1)
            System.out.println(a1);
        else
            System.out.println(a);

    }
}