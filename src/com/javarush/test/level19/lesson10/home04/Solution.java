package com.javarush.test.level19.lesson10.home04;

        import java.io.*;
        import java.nio.charset.StandardCharsets;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;
        import java.util.StringTokenizer;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine()), StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ,:;\"?!");
            int i = 0;
            while(stringTokenizer.hasMoreTokens()) {
                String a = stringTokenizer.nextToken();
                for (String word : words) {
                    if (a.equals(word)) ++i;
                }
            }
            if (i == 2) System.out.println(line);
        }
        reader.close();
        scanner.close();
    }
}
