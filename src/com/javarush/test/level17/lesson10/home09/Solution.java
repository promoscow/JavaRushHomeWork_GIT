package com.javarush.test.level17.lesson10.home09;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File aL = new File(reader.readLine());
        File fRL = new File(reader.readLine());
        Scanner scaL = new Scanner(aL);
        while(scaL.hasNext()) {
            allLines.add(scaL.next());
        }
        //System.out.println("allLines:");
        //System.out.println(allLines.toString());
        Scanner scfRL = new Scanner(fRL);
        while(scfRL.hasNext()) {
            forRemoveLines.add(scfRL.next());
        }
        //System.out.println("forRemoveLines:");
        //System.out.println(forRemoveLines.toString());
        //System.out.println("-");
        new Solution().joinData();
    }

    public  void joinData() throws CorruptedDataException
    {
        List<String> tempList = new ArrayList<>();
        for (String forRemoveLine : forRemoveLines)
        {
            for (String allLine : allLines)
            {
                if (forRemoveLine.equals(allLine)) tempList.add(forRemoveLine);
            }
        }
        //System.out.println("tempList: " + tempList.toString());
        //System.out.println("forRemoveLines: " + forRemoveLines.toString());
        if (tempList.toString().equals(forRemoveLines.toString())) {
            Iterator<String> iterator = allLines.iterator();
            while(iterator.hasNext()) {
                String tempI = iterator.next();
                for (String forRemoveLine : forRemoveLines)
                {
                    if (tempI.equals(forRemoveLine)) {
                        //System.out.println("deleting: " + tempI);
                        iterator.remove();
                    }
                }
            }
            //System.out.println("allLines: " + allLines.toString());

            /*          транзакционная перезапись файла!!!
            try {
                Formatter f = new Formatter("tempNumbs.txt");
                for (String s : allLines)
                {
                    System.out.println(s);
                    f.format("%s\r\n", s);
                }
                f.close();
            } catch (Exception e) {
                System.out.println("Error");
            }
            aL.delete();
            File tempFile = new File("tempNumbs.txt");
            File newFile = new File(aL.toString());
            if (tempFile.renameTo(newFile)) System.out.printf("renamed to %s\r\n", aL.toString());
            else System.out.println("didn't renamed");
            */

            /*
            InputStream is;         //стандартное копирование файла через поток. прям бери и вставляй в код
            OutputStream os;
            try {
                is = new FileInputStream(aL);
                os = new FileOutputStream("tempNumbs.txt");
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } catch (IOException e) {
                System.out.println("IOException");
            }
            */
        }
        else {
            allLines.clear();
            //System.out.println("allLines new: " + allLines.toString());
            throw new CorruptedDataException();
        }
    }
}
