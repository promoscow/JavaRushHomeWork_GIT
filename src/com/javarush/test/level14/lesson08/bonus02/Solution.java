package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        int x = 0;
        int nod = 1;
        if (a > b) x = b;
        else x = a;

        for (int i = 1; i < (x + 1); i++)
        {
            if ((a % i) == 0 && (b % i) == 0) nod = i;
        }

        System.out.println(nod);
    }
}
