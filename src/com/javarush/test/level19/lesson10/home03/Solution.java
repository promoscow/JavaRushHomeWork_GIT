package com.javarush.test.level19.lesson10.home03;

        import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.nio.charset.StandardCharsets;
        import java.text.ParseException;
        import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        Calendar birthdayCalendar = new GregorianCalendar();
        BufferedReader idReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
        String line;
        while ((line = idReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            String[] data = new String[stringTokenizer.countTokens()];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                data[i++] = stringTokenizer.nextToken();
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < data.length - 3; j++) {
                stringBuilder.append(data[j]);
                stringBuilder.append(" ");
            }
            String name = stringBuilder.toString().trim();
            birthdayCalendar.set(Integer.parseInt(data[data.length - 1]), (Integer.parseInt(data[data.length - 2]) - 1), Integer.parseInt(data[data.length - 3]));
            PEOPLE.add(new Person(name, birthdayCalendar.getTime()));
        }
        idReader.close();
    }
}
