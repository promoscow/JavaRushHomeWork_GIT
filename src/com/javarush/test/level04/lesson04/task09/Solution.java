package com.javarush.test.level04.lesson04.task09;

/* Светофор
Работа светофора для пешеходов запрограммирована следующим образом: в начале каждого часа в течение трех минут горит зеленый сигнал,
затем в течение одной минуты — желтый, а потом в течение одной минуты — красный, затем опять зеленый горит три минуты и т. д.
Ввести с клавиатуры вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.
Определить, сигнал какого цвета горит для пешеходов в этот момент.
Результат вывести на экран в следующем виде:
"зеленый" - если горит зеленый цвет, "желтый" - если горит желтый цвет, "красный" - если горит красный цвет.
Пример для числа 2.5:
зеленый
Пример для числа 3:
желтый
Пример для числа 4:
красный
Пример для числа 5:
зеленый
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String t = reader.readLine();
        int a = Integer.parseInt(t);
        if (a >= 0 && a < 3 || a >= 5 && a < 8 || a>= 10 && a < 13 || a>= 15 && a < 18 || a>=20 && a < 23 || a>=25 && a < 28 || a>= 30 && a < 33 || a>= 35 && a < 38 || a>= 40 && a < 43 || a>= 45 && a < 48 || a>= 50 && a < 53 || a>= 55 && a < 58)
            System.out.println("зеленый");
        else if (a >= 3 && a < 4 || a >= 8 && a < 9 || a >= 13 && a < 14 || a >= 18 && a < 19 || a >= 23 && a < 24 || a >= 28 && a < 29 || a >= 33 && a < 34 || a >= 38 && a < 39 || a >= 43 && a < 44 || a >= 48 && a < 49 || a >= 53 && a < 54 || a >= 58 && a < 59)
            System.out.println("желтый");
        else
            System.out.println("красный");
    }
}