package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int a1 = 0;
        int a = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (a1 != -1)
        {
            String t1 = reader.readLine();
            a1 = Integer.parseInt(t1);
            a = a + a1;

        }
        System.out.println(a);
    }
}
