package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        String result = outputStream.toString();
        System.setOut(consoleStream);
        String string = change(result);
        System.out.println(string);
    }

    private static String change(String outputStream) {
        char[] ch = outputStream.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 't' && ch[i + 1] == 'e') {
                ch[i] = '?';
                ch[i + 1] = '?';
            }
            builder.append(Character.toString(ch[i]));
        }
        return builder.toString();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
    }
    }
}
