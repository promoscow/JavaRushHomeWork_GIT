package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Госдума назвала репрессиями отстранение легкоатлетов от Олимпиады");
        list.add("Президент Финляндии заступился за Путина перед Швецией");
        list.add("Постпреды ЕС договорились продлить санкции против России на полгода");
        list.add("ВКС России провели успешное испытание противоракеты ПРО");
        list.add("Сорос заявил о перспективе развала ЕС и укреплении России");

        System.out.println(list.size());

        for (int i = 0; i < 5; i++)
        {
            System.out.println(list.get(i));
        }

    }
}
