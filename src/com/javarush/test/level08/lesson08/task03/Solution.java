package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {

    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        {
            map.put("Иванов", "Иван");
            map.put("Петров", "Пиотр");
            map.put("Сидоров", "Сидор");
            map.put("Козлов", "Козиол");
            map.put("Смирнов", "Пиотр");
            map.put("Воробиов", "Воробей");
            map.put("Гусев", "Гусь");
            map.put("Мартон", "Мормон");
            map.put("Баранов", "Баран");
            map.put("жигулиов", "Иван");
        }
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int x = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name))
                x++;
        }
        return x;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {

        int x = 0;
        for (Map.Entry<String, String> pair2 : map.entrySet()) {
            if (pair2.getKey().equals(lastName))
                x++;
        }
        return x;

    }
}
