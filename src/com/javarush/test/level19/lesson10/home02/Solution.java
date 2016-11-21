package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader idReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
        TreeMap<String, Double> list = new TreeMap<>();
        String line;
        double max = Double.MIN_VALUE;
        while ((line = idReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            String name = stringTokenizer.nextToken();
            double money = Double.parseDouble(stringTokenizer.nextToken());
            if (list.containsKey(name)) list.put(name, (list.get(name) + money));
            else list.put(name, money);
        }
        for (Double aDouble : list.values()) {
            if (max < aDouble) max = aDouble;
        }
        for (Map.Entry<String, Double> entry : list.entrySet()) {
            if (entry.getValue() == max) System.out.println(entry.getKey());
        }
        idReader.close();
    }
}
