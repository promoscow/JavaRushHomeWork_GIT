package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        File x = new File(args[0]);
        int sum = 0;
        Scanner scanner = new Scanner(x);
        StringBuilder stringBuilder = new StringBuilder();
        while(scanner.hasNext()) {
            stringBuilder.append(scanner.next());
        }
        char[] ch = stringBuilder.toString().toCharArray();
        for (char aCh : ch) {
            if (matchEnglish(aCh)) sum++;
        }
        System.out.println(sum);
        scanner.close();
    }

    private static boolean matchEnglish(char c) {
        String a = Character.toString(c);
        Pattern p = Pattern.compile("^[a-zA-Z]$");
        Matcher m = p.matcher(a);
        return m.matches();
    }
}
