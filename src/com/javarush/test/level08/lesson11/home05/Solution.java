package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код

        StringBuilder stringBuilder = new StringBuilder();          //здесь будет обновлённая фраза
        char[] c;
        String a;
        StringTokenizer st = new StringTokenizer(s, " \t\n\r,.");           //создаём StringTokenizer, который режет фразу по пробелам, запятым, точкам.
        while(st.hasMoreTokens())           //запускаем цикл вывода слов из токена
        {
            a = st.nextToken();             //присваиваем переменной стринг слово из токена
            c = a.toCharArray();            //разбиваем слово на посимвольный char-массив
            c[0] = Character.toUpperCase(c[0]);         //поднимаем первую букву в слове (первый символ в char-массиве)
            stringBuilder.append(c);            //пришиваем к фразе это слово (char-массиив целиком)
            stringBuilder.append(" ");          //пришиваем пробел
        }
        System.out.println(stringBuilder.toString().trim());            //выводим фразу целиком, обрезаем пробелы
    }


}
