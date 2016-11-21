package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<String> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<>();
        int i = 0;
        while (i < 10)
        {
            map.put("Кот" + i, new Cat("CAT" + i));
            i++;
        }

        return map;
    }

    public static Set<String> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<String> listCat = new HashSet<>();
        Iterator<Map.Entry <String, Cat>> iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            String value = iterator.next().getKey();
            listCat.add(value);
        }

        return listCat;
    }

    public static void printCatSet(Set<String> set)
    {
        for (String cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
