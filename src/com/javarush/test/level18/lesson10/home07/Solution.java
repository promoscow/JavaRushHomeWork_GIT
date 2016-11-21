package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

        import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.nio.charset.StandardCharsets;
        import java.util.ArrayList;
        import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader idReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = idReader.readLine()) != null) {
            list.add(line);
        }
        for (String s : list) {
            ArrayList<String> goodArray = new ArrayList<>();
            StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
            while(stringTokenizer.hasMoreTokens()) {
                goodArray.add(stringTokenizer.nextToken());
            }
            if (args[0].equals(goodArray.get(0))) {
                printGood(goodArray);
                break;
            }
        }
        reader.close();
        idReader.close();
    }

    private static void printGood(ArrayList<String> goodArray) {
        for (int i = 0; i < goodArray.size() - 1; i++) {
            System.out.print(goodArray.get(i) + " ");
        }
        System.out.println(goodArray.get(goodArray.size() - 1));
    }
}
