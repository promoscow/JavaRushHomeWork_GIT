package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] c;
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String a;
        StringTokenizer st = new StringTokenizer(s, " \t\n\r");           //создаём StringTokenizer, который режет фразу по пробелам.
        while(st.hasMoreTokens())           //запускаем цикл вывода слов из токена
        {
            a = st.nextToken();             //присваиваем переменной стринг слово из токена
            c = a.toCharArray();            //разбиваем слово на посимвольный char-массив
            for (char aC : c)
            {
                boolean vowel = isVowel(aC);
                if (vowel)
                {
                    list.add(String.valueOf(aC));
                } else
                {
                    list2.add(String.valueOf(aC));
                }

            }

        }
        for (String w : list)
        {
            System.out.print(w + " ");
        }
        System.out.println();
        for (String w1 : list2)
        {
            System.out.print(w1 + " ");
        }
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
