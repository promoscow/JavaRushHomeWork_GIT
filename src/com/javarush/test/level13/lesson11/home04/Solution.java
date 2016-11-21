package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/
import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String write = reader.readLine();
        ArrayList<String> list = new ArrayList<>();

        while(true)
        {
            String readString = reader.readLine();
            if (readString.equals("exit"))
            {
                list.add(readString);
                break;
            }
            list.add(readString);
        }

        FileWriter writer = new FileWriter(write);
        for (String text : list)
        {
            writer.write(text);
            writer.write(System.getProperty("line.separator"));
        }
        reader.close();
        writer.close();

        /*
        OutputStream outStream = new FileOutputStream(write);

        for (String text : list)
        {
            outStream.write(text.getBytes());
            outStream.write(Integer.parseInt(System.getProperty("line.separator")));

        }

        reader.close();
        outStream.close();
        */


    }
}
