package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

        import java.io.*;
        import java.nio.charset.StandardCharsets;
        import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
        String line;
        boolean isntFirst = false;
        while ((line = bufferedReader.readLine()) != null) {    //берём строку
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            StringBuilder sb = new StringBuilder();
            while(stringTokenizer.hasMoreTokens()) {
                String a = stringTokenizer.nextToken();
                if (a.length() > 6 && stringTokenizer.hasMoreTokens()) {
                    sb.append(a);
                    sb.append(",");
                }
                else if (a.length() > 6) {
                    sb.append(a);
                    sb.append("\n");
                }
            }
            String x = sb.toString();    //строка готова для записи
            File file = new File(args[1]);
            FileWriter fr = new FileWriter(file, isntFirst);
            isntFirst = true;
            fr.write(x);    //без закрытия этого потока файл не запишется
            fr.close();
        }
        bufferedReader.close();
    }
}
