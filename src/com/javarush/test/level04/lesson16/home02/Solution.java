package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String t1 = reader.readLine();
        int a1 = Integer.parseInt(t1);
        String t2 = reader.readLine();
        int a2 = Integer.parseInt(t2);
        String t3 = reader.readLine();
        int a3 = Integer.parseInt(t3);

        if (a1 < a2 && a1 > a3)
            System.out.println(a1);
        else if (a2 < a1 && a2 > a3)
            System.out.println(a2);
        else System.out.println(a3);
    }
}
