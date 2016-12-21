package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        if (args.length > 0) process(args, fileName);
        scanner.close();
    }

    private static void process(String[] args, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        PrintWriter writer = new PrintWriter(new FileWriter(fileName + "_temp.txt"));
        String line;
        boolean firstLine = true;
        while ((line = reader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            String id = stringTokenizer.nextToken();
            if (!id.equals(args[1])) {
                if (!firstLine) writer.println();
                else firstLine = false;
                writer.print(line);
            }
            else {
                if (args[0].equals("-u")) {
                    line = update(args);
                    if (!firstLine) writer.println();
                    else firstLine = false;
                    writer.print(line);
                }
            }
        }
        File file = new File(fileName);    //переименование файла — начало кода
        File tempFile = new File(fileName + "_temp.txt");
        tempFile.renameTo(file);    //переименование файла - конец кода
        reader.close();
        writer.close();
    }

    private static String update(String[] args) {
        String id = String.format("%1$-8.8s", args[1]);
        String productName = String.format("%1$-30.30s", createProductName(args));
        String price = String.format("%-8.8s", String.format(Locale.US, "%.2f", Double.parseDouble(args[args.length - 2])));
        String quantity = String.format("%-4.4s", Integer.parseInt(args[args.length - 1]));
        String line = id + productName + price + quantity;
        return line;
    }

    private static String createProductName(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i < args.length - 2; i++) {
            builder.append(args[i]);
            builder.append(" ");
        }
        return builder.toString();
    }
}
