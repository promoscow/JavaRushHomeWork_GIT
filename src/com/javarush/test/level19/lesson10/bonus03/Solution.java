package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        ArrayList<Character> chars = new ArrayList<>();
        int symbol;
        while ((symbol = reader.read()) != -1) {
            chars.add((char) symbol);
        }

        char[] tagChar = args[0].toCharArray();
        int x = 0;    //x служит триггером для вывода. если нашли span, то x++, если нашли /span, то x--. Если при этом x == 0, то вывод, если при этом x != 0, то x--;
        int pointer = 0;
        for (int i = 0; i < chars.size(); i++) {    // главный цикл
//            System.out.print(chars.get(i) + "!");
            if (chars.get(i) == tagChar[0]) {    // нашли нужный символ
                int comparison = 1;
                for (int j = 1; j < tagChar.length; j++) {
                    if (chars.get(i + j) == tagChar[j]) comparison++;
                }
                if (comparison == tagChar.length) {    // нашли тэг
                    if (chars.get(i - 1) == '<') {    // если тэг открывающий
                        if (x == 0) pointer = i;    // если тэг первый и открывающий, то ставим точку
                        x++;
                    }
                    if (chars.get(i - 1) == '/' && (x != 0)) {
                        x--;
                        if (x == 0) {    // если уровень совпадает
                            for (int j = pointer - 1; j < i + tagChar.length + 1; j++) {
                                if (chars.get(j) != 10) {
                                    System.out.print(chars.get(j));
                                }
                            }
                            System.out.println();
                            i = pointer + tagChar.length;
                        }
                    }
                }
            }
        }
        scanner.close();
        reader.close();
    }
}
