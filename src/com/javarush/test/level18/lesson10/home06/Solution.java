package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        int c;
        while ((c = reader.read()) != -1) {
            int x = (char) c;
            int z = 1;
            for (Map.Entry<Integer, Integer> integer : map.entrySet()) {
                if (integer.getKey() == x) {
                    z += integer.getValue();
                }
            }
            map.put(x, z);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(((char) (int) entry.getKey()) + " " + entry.getValue());
        }
        reader.close();
    }
}
