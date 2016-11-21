package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);
        FileOutputStream outputStream = new FileOutputStream(file1);
        byte[] buffer = new byte[1000];
        while (fileInputStream2.available() > 0)
        {
            int count = fileInputStream2.read(buffer);
            outputStream.write(buffer, 0, count);
        }
        while (fileInputStream3.available() > 0)
        {
            int count2 = fileInputStream3.read(buffer);
            outputStream.write(buffer, 0, count2);
        }
        reader.close();
        fileInputStream2.close();
        fileInputStream3.close();
        outputStream.close();
    }
}
