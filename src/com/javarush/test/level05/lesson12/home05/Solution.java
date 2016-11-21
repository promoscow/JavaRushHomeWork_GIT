package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;

        while (true)
        {
            String s = reader.readLine();
            if (s.equals("сумма"))
                break;
            else
            {
                int i = Integer.parseInt(s);
                a = a + i;
            }
        }
        System.out.println(a);
    }
}
