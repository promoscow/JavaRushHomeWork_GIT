package com.javarush.test.level04.lesson06.task06;

/* И 18-ти достаточно
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно».
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

        if (a1 > 20)
            System.out.print("И 18-ти достаточно");

    }
}
