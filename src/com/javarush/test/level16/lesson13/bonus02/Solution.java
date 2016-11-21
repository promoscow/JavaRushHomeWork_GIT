package com.javarush.test.level16.lesson13.bonus02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/
public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
        threads.add(new AlwaysRuner());
        threads.add(new InterruptedExceptionDetecter());
        threads.add(new Lucky());
        threads.add(new Messenger());
        threads.add(new Adder());
    }
    public static class AlwaysRuner extends Thread{
        @Override
        public void run() {
            while (true){}
        }
    }
    public static class InterruptedExceptionDetecter extends Thread{
        @Override
        public void run() {
            try {
                while (!isInterrupted()){
                    sleep(1);
                }
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Lucky extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");
                    sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public static class Messenger extends Thread implements Message{
        @Override
        public void run() {
            while(!isInterrupted()) {

            }
        }
        @Override
        public void showWarning() {
            try {
                interrupt();
                join();
            } catch (InterruptedException e) {
            }
        }
    }
    public static class Adder extends Thread{
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s;
            int summa = 0;
            try {
                while (!( (s = reader.readLine() ).equals("N"))){
                    summa += Integer.parseInt(s);
                }
                reader.close();
            } catch (IOException e) {
            }
            System.out.println(summa);
        }
    }
}