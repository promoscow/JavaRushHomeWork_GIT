package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        int c;
        for (c=1;c<11;c++)
        {
            int a;
            for (a = 1; a < 11; a++)
            {
                if (a<10)
                {
                    System.out.print((a * c) + " ");
                }
                else
                {
                    System.out.println(a * c);
                }
            }
        }


    }
}