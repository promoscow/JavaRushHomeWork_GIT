package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        int x;
        int y;
        int z;

        if (a1 > a2 && a1 > a3)
            x = a1;
        else if (a2 > a1 && a2 > a3)
            x = a2;
        else x = a3;

        if (a1 < a2 && a1 < a3)
            z = a1;
        else if (a2 < a1 && a2 < a3)
            z = a2;
        else z = a3;

        if (a1 > z && a1 < x)
            y = a1;
        else if (a2 > z && a2 < x)
            y = a2;
        else y = a3;




        System.out.println(x + " " + y + " " + z);

    }
}
