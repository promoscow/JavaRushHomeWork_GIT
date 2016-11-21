package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        String a = "Мама";
        String b = "Мыла";
        String c = "Раму";

        System.out.print(a);
        System.out.print(b);
        System.out.println(c);
        System.out.print(b);
        System.out.print(a);
        System.out.println(c);
        System.out.print(c);
        System.out.print(a);
        System.out.println(b);
        System.out.print(a);
        System.out.print(c);
        System.out.println(b);
        System.out.print(b);
        System.out.print(c);
        System.out.println(a);
        System.out.print(c);
        System.out.print(b);
        System.out.println(a);


    }
}