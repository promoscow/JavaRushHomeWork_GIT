package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> month = new HashSet<>();
        {
            String x = reader.readLine();
            int a = 0;
            month.add(x);

            for (String c : month)
            {
                if (c.equals("January"))
                    a = 1;
                else if (c.equals("February"))
                    a = 2;
                else if (c.equals("March"))
                    a = 3;
                else if (c.equals("April"))
                    a = 4;
                else if (c.equals("May"))
                    a = 5;
                else if (c.equals("June"))
                    a = 6;
                else if (c.equals("July"))
                    a = 7;
                else if (c.equals("August"))
                    a = 8;
                else if (c.equals("September"))
                    a = 9;
                else if (c.equals("Octcober"))
                    a = 10;
                else if (c.equals("November"))
                    a = 11;
                else if (c.equals("December"))
                    a = 12;
                System.out.println(c + " is " + a + " month");
            }


        }


    }

}
