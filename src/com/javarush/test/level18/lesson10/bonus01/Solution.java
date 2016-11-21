package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[1]);
        ArrayList<Integer> bytes = new ArrayList<>();
        while (inputStream.available() > 0) {
            bytes.add(inputStream.read());
        }
        ArrayList<Integer> output = new ArrayList<>();
        if (args[0].equals("-e")) output = encrypt(bytes);
        else if (args[0].equals("-d")) output = decrypt(bytes);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        for (Integer integer : output) {
            outputStream.write(integer);
        }
        inputStream.close();
        outputStream.close();
    }
    private static ArrayList<Integer> encrypt(ArrayList<Integer> bytes) {
        return bytes.stream().map(aByte -> aByte + 3).collect(Collectors.toCollection(ArrayList::new));
    }
    private static ArrayList<Integer> decrypt(ArrayList<Integer> bytes) {
        return bytes.stream().map(aByte -> aByte - 3).collect(Collectors.toCollection(ArrayList::new));
    }
}
