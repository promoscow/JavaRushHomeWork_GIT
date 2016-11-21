package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by promoscow on 14.08.16.
 */
public class Singleton
{
    private static Singleton i;
    public static Singleton getInstance()
    {

        if(i==null)
            i=new Singleton();
        return i;
    }
    private Singleton()
    {

    }
}
