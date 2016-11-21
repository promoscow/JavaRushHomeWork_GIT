package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String n1 = reader.readLine();
        String n2 = reader.readLine();
        int a1 = Integer.parseInt(n2);

        if (a1 < 18)
            System.out.print("Подрасти еще");

    }
}
