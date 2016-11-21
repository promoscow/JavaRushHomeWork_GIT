package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        if (args.length > 0)
            if (args[0].equals("-c"))
                add(args, fname);
        reader.close();
    }
    public static int getLastId(String fname) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fname));
        int maxId = Integer.MIN_VALUE;
        while (file.hasNextLine())
        {
            String line = file.nextLine();
            int id = Integer.parseInt(line.substring(0, 8).trim());
            if (id > maxId)
                maxId = id;
        }
        file.close();
        return maxId;
    }
    public static void add(String[] args, String fname) throws IOException {
        if (args.length < 4)
            return;
        FileWriter file = new FileWriter(fname, true);
        String id = String.format("%-8.8s", getLastId(fname) + 1);
        String productName = String.format("%-30.30s", getProductNameInArgs(args));
        String price = String.format("%-8.8s", String.format(Locale.US, "%.2f", Double.parseDouble(args[args.length-2])));
        String quantity = String.format("%-4.4s", args[args.length-1]);
        file.write(System.getProperty( "line.separator" ));
        file.write(id + productName + price + quantity);
        file.close();
    }
    public static String getProductNameInArgs(String[] args) {
        StringBuilder productName = new StringBuilder();
        for (int i = 1; i < args.length - 2; i++) {
            productName.append(args[i]);
            productName.append(" ");
        }
        return productName.toString();
    }
}
