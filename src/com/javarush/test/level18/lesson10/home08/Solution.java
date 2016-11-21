package com.javarush.test.level18.lesson10.home08;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String s = scanner.nextLine();
            if (s.equals("exit")) break;
            new ReadThread(s).start();
        }
        scanner.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                ArrayList<Integer> bytes = new ArrayList<>();
                while (inputStream.available() > 0) {
                    int x = inputStream.read();
                    bytes.add(x);
                    System.out.print(x + " ");
                }
                int x = 0;    //максимальное количество повторений до следующего цикла
                int max;
                if (bytes.size() > 0) {
                    max = bytes.get(0);    //значение байта, повторяющегося максимальное количество раз
                    for (int i = 0; i < bytes.size(); i++) {
                        int count = 0;
                        for (Integer aByte : bytes) {
                            if (Objects.equals(bytes.get(i), aByte)) count++;
                        }
                        if (count > x) {
                            x = count;
                            max = bytes.get(i);
                        }
                    }
                } else max = 0;
                System.out.println("---------");
                System.out.println(fileName + " : " + max);
                resultMap.put(fileName, max);
                inputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
