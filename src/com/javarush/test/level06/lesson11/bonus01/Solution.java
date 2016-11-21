package com.javarush.test.level06.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;//решение 1 - вывести 3 эти строки, их не было

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два числа с клавиатуры и выводит их максимум в виде «Max is 25»
*/

public class Solution
{
    public static int max1 = 100;//решение 2: max заменить на max1
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        String max = "Max is ";
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        max1 = a > b ? a : b;

        System.out.println(max + max1);
    }

}
