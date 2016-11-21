package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5

SS
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка4            ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine()), StandardCharsets.UTF_8));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine()), StandardCharsets.UTF_8));
        ArrayList<String> list1 = listFill(reader1);
        ArrayList<String> list2 = listFill(reader2);
        int j = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (Objects.equals(list1.get(i), list2.get(j))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                if ((j + 1) < list2.size()) j++;
                else if (i < list1.size() - 1){
                    lines.add(new LineItem(Type.REMOVED, list1.get(i + 1)));
                    break;
                } else break;
            } else if (Objects.equals(list1.get(i), list2.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                if ((j + 2) < list2.size()) j += 2;
                else {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i + 1)));
                    break;
                }
            } else lines.add(new LineItem(Type.REMOVED, list1.get(i)));
        }
        if (j < list2.size()) lines.add(new LineItem(Type.ADDED, list2.get(j)));
        scanner.close();
        reader1.close();
        reader2.close();
    }

    private static ArrayList<String> listFill(BufferedReader reader) throws IOException {
        String line;
        ArrayList<String> list = new ArrayList<>();
        while ((line = reader.readLine()) != null) list.add(line);
        return list;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
