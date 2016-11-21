package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader reader = new FileReader(scanner.nextLine());
        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            char data = (char)(reader.read());
            String data2 = String.valueOf(data);
            builder.append(data2);
        }
        StringTokenizer st = new StringTokenizer(builder.toString().trim(), " \n\t\r!#$%&()*+,-./:;<=>?@[]^_`{|}~");
        String[] words = new String[st.countTokens()];
        int count = 0;
        while(st.hasMoreTokens()) {
            words[count++] = st.nextToken();
        }
        int x = 0;
        for (String word : words) {
            if (word.equals("world")) x++;
        }
        System.out.println(x);
        //закрываем потоки после использования
        reader.close();
        scanner.close();
    }
}
