package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();

        simpleOutput(x);
        objOutput(x);
    }


    private static void simpleOutput(String x)
    {
        char[] urlToChars = x.toCharArray();
        boolean sw = false;         //true - значит, со следующего символа печатаем. false - значит, со следующего символа не печатаем.
        int k = 0;          //если k > 0 — вместо символа печатаем пробел

        for (int i = 0; i < urlToChars.length; i++)
        {

            String c = String.valueOf(urlToChars[i]);
            if (c.equals("="))
            {
                sw = false;
            }
            if ((sw) && (!c.equals("&")))           //в случае, если параметры идут друг за другом, через &, то sw не перещёлкивается и дописывает & к параметру. это неравенство проверяет, не является ли печатаемый символ &
            {
                System.out.print(c);            //если sw перещёлкнуто в значение "параметр", печатаем символ
            }
            if (c.equals("?") || (c.equals("&")))           //если у нас ? или &, печатаем пробел и перещёлкиваем sw
            {
                if (k > 0)          //если sw перещёлкнулось в "параметр" не в первый раз, печатаем пробел
                {
                        sw = true;
                        System.out.print(" ");
                }
                else            //иначе, не печатаем и делаем "не в первый раз"
                {
                    k++;
                    sw = true;
                }
            }
        }
    }

    private static void objOutput(String x)
    {
        System.out.println();
        StringTokenizer stn = new StringTokenizer(x, "?&=");            //разбили на токены
        boolean num = false;            //если obj, то true, параметр - false
        while(stn.hasMoreTokens())
        {
            String tok = stn.nextToken();
            if (num)
            {
                num = false;
                try
                {
                    double m = (Double.parseDouble(tok));
                    alert(m);
                }
                catch (NumberFormatException e)
                {
                    alert(tok);
                }
            }
            if (tok.equals("obj")) num = true;

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
