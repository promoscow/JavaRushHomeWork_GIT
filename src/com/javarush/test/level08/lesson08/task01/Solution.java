package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();
        {
            set.add("Ленин");
            set.add("Лапоть");
            set.add("Лидия");
            set.add("Лилия");
            set.add("Ластик");
            set.add("Ласты");
            set.add("Лотос");
            set.add("Лучший");
            set.add("Лепнина");
            set.add("Листок");
            set.add("Ласточка");
            set.add("Лом");
            set.add("Луч");
            set.add("Липкий");
            set.add("Лето");
            set.add("Ларец");
            set.add("Лоск");
            set.add("Локоть");
            set.add("Лик");
            set.add("Лава");
        }
        return set;

    }
}
