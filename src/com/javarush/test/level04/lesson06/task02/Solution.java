package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        String t2 = reader.readLine();
        int a2 = Integer.parseInt(t2);
        String t3 = reader.readLine();
        int a3 = Integer.parseInt(t3);

        if (a < a1)
            a = a1;
        if (a < a2)
            a = a2;
        if (a < a3)
            a = a3;

        System.out.println(a);


    }
}
