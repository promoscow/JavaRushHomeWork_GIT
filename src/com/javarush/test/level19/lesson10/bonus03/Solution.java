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
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String line;
        char[] args1 = args[0].toCharArray();
        while ((line = reader.readLine()) != null) {
//            boolean isOpened = false;
            char[] ch = line.toCharArray();
            int xRight = 0;
            int toLeft = ch.length - 1;
            for (int i = 0; i < ch.length; i++) {    //глобальный цикл по строке
                int xLeft = 0;
                for (int j = 0; j < args1.length; j++) {    //локальный цикл поиска совпадения
                    if (args1[j] == ch[i + j]) xLeft++;
                }
                    if (xLeft == args1.length) {
                        while (true) {
                            for (int j = args1.length - 1; j > 0; j--) {
                                if (args1[j] == ch[toLeft - args.length + 1 + j]) xRight++;
                            }
                            if (xRight == args1.length) {
                                xRight = 0;
                                System.out.print(ch[i - 1]);
                                for (int j = i; j < toLeft; j++) {
                                    System.out.print(ch[j]);
                                }
                                System.out.println(ch[toLeft + 1]);
                                toLeft -= args1.length;
                                break;
                            }
                            toLeft--;
                        }
                    }
                }
            }
        }
    }
