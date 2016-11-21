package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String n1 = reader.readLine();
        String n2 = reader.readLine();

        int a1 = n1.length();
        int a2 = n2.length();

        if (n1.equals(n2))
            System.out.println("Имена идентичны");

        else if (a1 == a2)
            System.out.println("Длины имен равны");


    }
}
