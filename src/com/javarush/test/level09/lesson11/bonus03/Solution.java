package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);         //создаём из ArrayList массив array
        sort(array);            //сортируем

        for (String x : array)          //выводим на экран
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> nums = new ArrayList<>();            //учёт цифровых значений
        ArrayList<Integer> words = new ArrayList<>();            //учёт значений-слов
        int numsCount = 0;          //счётчик чисел
        int wordsCount = 0;         //счётчик слов
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))            //"если число"
            {
                nums.add(numsCount, i);            //занесли номер значения массива array в массив учёта цифровых значений
                numsCount += 1;
            }
            else
            {
                words.add(wordsCount, i);
                wordsCount += 1;
            }
        }

        /*отладка
        for (int i = 0; i < nums.size(); i++)
        {
            System.out.println(nums.get(i));
        }
        System.out.println("числа");

        for (int i = 0; i < words.size(); i++)
        {
            System.out.println(words.get(i));
        }
        System.out.println("слова");

        System.out.println("==============");
        */

        //сортировка чисел методом перебора, иначе никак
        for (int i = 0; i < nums.size(); i++)
        {
            int intArray = Integer.parseInt(array[nums.get(i)]);            //берём число и переводим его в String
            int min = intArray;         //min = цифровое значение числа из массива чисел
            int min_i = nums.get(i);            //nums.get[i] - это i из метода перебора

            for (int j = i + 1; j < nums.size(); j++)
            {
                int intArrayJ = Integer.parseInt(array[nums.get(j)]);
                if (intArrayJ > min)
                {
                    min = intArrayJ;
                    min_i = nums.get(j);
                }
            }
            if (nums.get(i) != min_i)
            {
                String tmp = array[nums.get(i)];
                array[nums.get(i)] = array[min_i];
                array[min_i] = tmp;

            }
        }

        //сортировка слов методом перебора
        for (int i = 0; i < words.size(); i++)
        {
            String aMin = array[words.get(i)];          //взяли слово из массива
            int aMin_i = words.get(i);          //индекс этого слова в массиве

            for (int j = i + 1; j < words.size(); j++)
            {
                String aMin2 = array[words.get(j)];
                if (isGreaterThan(aMin, aMin2))
                {
                    aMin = aMin2;
                    aMin_i = words.get(j);
                }
            }

            if (words.get(i) != aMin_i)
            {
                String tmp2 = array[words.get(i)];
                array[words.get(i)] = array[aMin_i];
                array[aMin_i] = tmp2;
            }
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)         //сравнивает, заглавная какого слова больше
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)            //определяет, строка или число
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
