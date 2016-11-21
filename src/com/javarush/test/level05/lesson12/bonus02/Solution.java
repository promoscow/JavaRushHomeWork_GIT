package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());//вводим 2 переменных

        int minimum = min(a, b);// вводим переменную minimum, значение которой - метод min c переменными a и b. Программа идёт в строку 32 выяснять значение min, чтобы присвоить его переменной minimum

        for (int i = 0; i < 3; i++)
        {
            int c = Integer.parseInt(reader.readLine());
            if (c < minimum)
                minimum = c;// простой цикл. вводим 3 числа, выясняем минимальное
        }

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b)// а вот и метод, который возвращает значение min.
    {
        return a < b ? a : b;//if a < b, return a, else return b
    }

}
