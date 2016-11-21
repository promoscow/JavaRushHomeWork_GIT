package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;    //сохраняем System.out в первоначальном виде в поток PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();    //создаём динамический массив
        System.setOut(new PrintStream(outputStream));    //меняем функционал System.out. теперь, когда будут попытки вызвать System.out, результат будет записан в outputStream; например, при вызове System.out.println("Hello!"); outputStream.toString = "Hello!", на экран ничего не выведется
        testString.printSomething();    //перехват
        String result = outputStream.toString();    //загоняем значение перехваченного System.out в строку
        System.setOut(consoleStream);    //заново учим System.out выводить текст на консоль
        String string = addContext(result);    //производим любые операции с перехваченной строкой. в нашем случае, перехватываются сразу все строки метода
        System.out.println(string);    //печатаем строку
    }

    private static String addContext(String result) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        char[] ch = result.toCharArray();
        for (char c : ch) {
            builder.append(c);
            if (c == 10) count++;
            if (count == 2) {
                builder.append("JavaRush - курсы Java онлайн\n");
                count = 0;
            }
        }
        result = builder.toString();
        return result;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
