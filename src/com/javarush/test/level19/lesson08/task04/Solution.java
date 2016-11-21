package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
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
        String string = solution(result);
        System.out.println(string);
    }

    private static String solution(String outputStream) {
        String sol = "";
        char[] ch = outputStream.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '=') {
                for (int j = 0; j < (i - 1); j++) {
                    if (ch[j] == '+' || ch[j] == '-' || ch[j] == '*') {
                        StringBuilder builder = new StringBuilder();
                        for (int k = 0; k < (j - 1); k++) {    //a
                            builder.append(Character.toString(ch[k]));
                        }
                        int a = Integer.parseInt(builder.toString());
                        StringBuilder builder1 = new StringBuilder();
                        for (int k = (j + 2); k < (i - 1) ; k++) {
                            builder1.append(Character.toString(ch[k]));
                        }
                        int b = Integer.parseInt(builder1.toString());
                        if (ch[j] == '+') sol = a + " + " + b + " = " + (a + b);
                        else if (ch[j] == '-') sol = a + " - " + b + " = " + (a - b);
                        else sol = a + " * " + b + " = " + (a * b);
                    }
                }
            }
        }
        return sol;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

