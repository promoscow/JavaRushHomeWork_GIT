package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix(2, 3, (Object) 8);
        printMatrix(2, 3, 8);
        printMatrix(2, 3, (byte) 8);
        printMatrix(2, 3, (long) 8);
        printMatrix(2, 3, (short) 8);
        printMatrix(2, 3, (Number) 8);
        printMatrix(2, 3, (int) 8);
        printMatrix(2, 3, (Integer) 8);
        printMatrix(2,3, (char) 8);

    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, Integer value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                System.out.print(Integer.parseInt(String.valueOf(value)));
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, byte value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                System.out.print(Integer.parseInt(String.valueOf(value)));
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, char value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                System.out.print(Integer.parseInt(String.valueOf(value)));
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, short value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                System.out.print(Integer.parseInt(String.valueOf(value)));
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, long value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                System.out.print(Integer.parseInt(String.valueOf(value)));
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, Number value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                System.out.print(Integer.parseInt(String.valueOf(value)));
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, int value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                System.out.print(Integer.parseInt(String.valueOf(value)));
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, float value)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                System.out.print(Integer.parseInt(String.valueOf(value)));
            }
            System.out.println();
        }
    }



}
