package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String outputFile = reader.readLine();
        BufferedReader stringReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
        String line = stringReader.readLine();
        ArrayList<Double> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line, " ");
        while(st.hasMoreTokens()) list.add(Double.parseDouble((st.nextToken())));
        int[] integers = new int[list.size()];
        int i = 0;
        for (Double aDouble : list) {
            if (aDouble > 0) integers[i++] = round1(aDouble);
            else if (aDouble < 0) integers[i++] = round2(aDouble);
            else integers[i++] = 0;
        }
        StringBuilder builder = new StringBuilder();
        for (int integer : integers) {
            builder.append(integer);
            builder.append(" ");
        }
        String x = builder.toString().trim();
        File file = new File(outputFile);
        FileWriter fr = new FileWriter(file);
            fr.write(x);    //без закрытия этого потока файл не запишется
        fr.close();
        reader.close();
        stringReader.close();
    }

    private static int round1(Double aDouble) {
        double x = aDouble;
        if ((int) (x + 0.5) == (int) x) return (int) x;
        else return (int) ++x;
    }

    private static int round2(Double aDouble) {
        double x = aDouble;
        if ((int) (x - 0.49) == (int) x) return (int) x;
        else return (int) --x;
    }
}
