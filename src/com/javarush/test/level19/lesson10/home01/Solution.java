package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        while ((line = idReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            String name = stringTokenizer.nextToken();
            double money = Double.parseDouble(stringTokenizer.nextToken());
            if (list.containsKey(name)) list.put(name, (list.get(name) + money));
            else list.put(name, money);
            }
        for (Map.Entry<String, Double> entry : list.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        idReader.close();
    }
}
