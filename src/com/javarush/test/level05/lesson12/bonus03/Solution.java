package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//пишется один разБ потом со второй строчки
        int N = Integer.parseInt(reader.readLine());//вводим число N
        int maximum = Integer.parseInt(reader.readLine());/* задаём число maximum. в хэлпах написано, что все вводимые числа могут быть меньше maximum, поэтому maximum у нас и есть первое число. */

        for (int i = 1; i < N; i++)//поскольку i уже равно 1, то к моменту достижения значения N произойдёт на 1 цикл меньше, что нам и надо, потому что у нас уже есть maximum
        {
            int m = Integer.parseInt(reader.readLine());

            if (m > maximum)
                maximum = m;//внутри цикла происходит определение новой переменной и присвоение maximum её значения, если m > maximum
        }



        System.out.println(maximum);
    }
}
