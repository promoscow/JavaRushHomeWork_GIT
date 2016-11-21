package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            while(stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                    char[] ch = word.toCharArray();
                    for (char c : ch) {
                        if (Character.isDigit(c)) {
                            builder.append(word);
                            builder.append(" ");
                            break;
                        }
                    }
            }
        }
        String x = builder.toString().trim();
        File file = new File(args[1]);
        FileWriter fr = new FileWriter(file);
        fr.write(x);    //без закрытия этого потока файл не запишется
        fr.close();
        bufferedReader.close();
    }
}
