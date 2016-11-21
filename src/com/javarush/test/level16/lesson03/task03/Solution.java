package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread thread = new SpecialThread();

        Thread thread1 = new Thread(thread);
        list.add(thread1);
        Thread thread2 = new Thread(thread);
        list.add(thread2);
        Thread thread3 = new Thread(thread);
        list.add(thread3);
        Thread thread4 = new Thread(thread);
        list.add(thread4);
        Thread thread5 = new Thread(thread);
        list.add(thread5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
