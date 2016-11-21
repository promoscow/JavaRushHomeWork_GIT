package com.javarush.test.level08.lesson11.home09;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        /*
        GregorianCalendar calendar = new GregorianCalendar(1975, Calendar.DECEMBER, 31);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(month);
        System.out.println(day);
        */

        /*
        StringTokenizer st = new StringTokenizer("MAY 11 2013", " \t\n\r,.");
        String month = st.nextToken();
        String d = st.nextToken();
        int day = Integer.parseInt(d);
        System.out.println(month + " " + day);
        */
    }

    public static boolean isDateOdd(String date)
    {

        StringTokenizer st = new StringTokenizer(date, " \t\n\r,.");
        String month = st.nextToken();
        String d = st.nextToken();
        int day = Integer.parseInt(d);
        int year = Integer.parseInt(st.nextToken());

        int z = 0;
        if (year % 4 == 0)
            z = 1;
        if (((year % 100) == 0) && (year % 400) == 0)
        {
            z = 1;
        }
        day = day - 1;

        //здесь надо высчитать, какой год - високосный или нет

        int x = 0;
        if (month.equals("JANUARY"))
            x = day + 0;
        if (month.equals("FEBRUARY"))
            x = day + 31;
        if (month.equals("MARCH"))
            x = day + 31 + 28 + z;
        if (month.equals("APRIL"))
            x = day + 31 + 28 + 31 + z;
        if (month.equals("MAY"))
            x = day + 31 + 28 + 31 + 30 + z;
        if (month.equals("JUNE"))
            x = day + 31 + 28 + 31 + 30 + 31 + z;
        if (month.equals("JULY"))
            x = day + 31 + 28 + 31 + 30 + 31 + 30 + z;
        if (month.equals("AUGUST"))
            x = day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + z;
        if (month.equals("SEPTEMBER"))
            x = day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + z;
        if (month.equals("OCTOBER"))
            x = day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + z;
        if (month.equals("NOVEMBER"))
            x = day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + z;
        if (month.equals("DECEMBER"))
            x = day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + z;

        if (x%2 == 0)
            return true;
        else return false;






    }
}
