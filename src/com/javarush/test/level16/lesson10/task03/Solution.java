package com.javarush.test.level16.lesson10.task03;

/* Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread thread = new TestThread();
        Thread.sleep(500);
        thread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public TestThread() {
            start();
        }

        public void run() {
            while (!isInterrupted()) {
                try
                {
                    Thread.sleep(1000);
                    System.out.println("Программа не была прервана.");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
