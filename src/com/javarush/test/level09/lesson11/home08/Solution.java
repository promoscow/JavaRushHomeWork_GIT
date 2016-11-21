package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Arrays;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int[] array1 = new int[5];
        list.add(array1);
        Arrays.fill(array1, 55);
        int[] array2 = new int[2];
        list.add(array2);
        Arrays.fill(array2, 22);
        int[] array3 = new int[4];
        list.add(array3);
        Arrays.fill(array3, 44);
        int[] array4 = new int[7];
        list.add(array4);
        Arrays.fill(array4, 77);
        int[] array5 = new int[0];
        list.add(array5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
