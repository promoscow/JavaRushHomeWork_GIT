package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();


        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            exceptions.get(1000);
        }
        catch (Exception q)
        {
            exceptions.add(q);
        }

        try
        {
            Object NoSuchObject = null;
            if(NoSuchObject.equals("knownObject"))
            {
                System.err.println("This may result in NullPointerException if unknownObject is null");
            }
        }
        catch (Exception w)
        {
            exceptions.add(w);
        }

        try
        {
            int i = 0;
            int[] nArray = new int[5];

            while(true)
            {
                try
                {
                    nArray[i] = i;
                }
                catch(Exception ex)
                {
                    System.out.println("\n" + ex.toString());
                    break;
                }

                System.out.print(i);
                i++;
            }
        }
        catch (Exception r)
        {
            exceptions.add(r);
        }

        try
        {
            String z = "sdfsd";
            int x = Integer.parseInt(z);
        }
        catch (Exception t)
        {
            exceptions.add(t);
        }

        try
        {
            Object[] s = new Integer[4];
            s[0] = 4.4;

        }
        catch (Exception y)
        {
            exceptions.add(y);
        }

        try
        {
            String z = "0978цук";
            int x = Integer.parseInt(z);
        }
        catch (Exception u)
        {
            exceptions.add(u);
        }

        try
        {
            String z = "09sdkfjhdsк";
            int x = Integer.parseInt(z);
        }
        catch (Exception u)
        {
            exceptions.add(u);
        }

        try
        {
            String z = "0978sdfdsfцук";
            int x = Integer.parseInt(z);
        }
        catch (Exception u)
        {
            exceptions.add(u);
        }

        try
        {
            String z = "09sdfds78цук";
            int x = Integer.parseInt(z);
        }
        catch (Exception u)
        {
            exceptions.add(u);
        }

        try
        {
            String z = "097sdfdf8цук";
            int x = Integer.parseInt(z);
        }
        catch (Exception u)
        {
            exceptions.add(u);
        }


    }
}
