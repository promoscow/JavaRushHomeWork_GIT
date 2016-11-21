package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int a = Integer.parseInt(name);
        String name1 = reader.readLine();
        int b = Integer.parseInt(name1);
        String name2 = reader.readLine();
        int c = Integer.parseInt(name2);

        if ((a + b) <= c)
            System.out.println("Треугольник не существует.");
        else if ((a + c) <= b)
            System.out.println("Треугольник не существует.");
        else if ((b + c) <= a)
            System.out.println("Треугольник не существует.");
        else System.out.println("Треугольник существует.");

    }
}