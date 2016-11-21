package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

        import java.io.*;
        import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        String file3Name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1Name);
        FileOutputStream file2 = new FileOutputStream(file2Name);
        FileOutputStream file3 = new FileOutputStream(file3Name);
        ArrayList<Integer> array = new ArrayList<>();
        while(inputStream.available() > 0) {
            array.add(inputStream.read());
        }
        if((array.size() % 2) == 0)
        {
            for (int i = 0; i < (array.size() / 2); i++)
            {
                file2.write(array.get(i));
            }
            for (int i = (array.size() / 2); i < array.size(); i++)
            {
                file3.write(array.get(i));
            }
        }
        else {
            for (int i = 0; i < (array.size() / 2 + 1); i++)
            {
                file2.write(array.get(i));
            }
            for (int i = (array.size() / 2 + 1); i < array.size(); i++)
            {
                file3.write(array.get(i));
            }
        }
        reader.close();
        inputStream.close();
        file2.close();
        file3.close();
    }
}
