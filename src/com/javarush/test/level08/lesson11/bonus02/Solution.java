package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> cities = new ArrayList<>();
        List<String> addresses = new ArrayList<String>();
        while (true)
        {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String family = reader.readLine();

            cities.add(city);
            addresses.add(family);
        }


        //read home number
        String cityIndex = reader.readLine();

        for (int i = 0; i < cities.size(); i++)
        {
            if (cityIndex.equals(cities.get(i)))
            {
                System.out.println(addresses.get(i));
            }
        }

        /*
        int houseNumber = Integer.parseInt(reader.readLine());

        if (0 <= houseNumber && houseNumber < addresses.size())
        {
            String familySecondName = addresses.get(houseNumber);
            System.out.println(familySecondName);
        }
        */
    }
}
