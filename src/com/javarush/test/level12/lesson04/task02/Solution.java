package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public void main(String[] args)
    {
        print(5);
        print(35743945);
    }

    //Напишите тут ваши методы
    public void print(int a)
    {
        System.out.println(a);
    }
    public void print(Integer b)
    {
        System.out.println(b);
    }
}
