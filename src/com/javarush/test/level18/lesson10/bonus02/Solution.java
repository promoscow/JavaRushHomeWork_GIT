package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

/*

#1

Объяснение String.format("%1$-8.8s");
% — начало формата
1$ — порядковый номер аргумента, который вставляется в формат
- — означает выравнивание по левому краю
8 — минимальное количество символов, которые будут выведены
.8 — ограничение на количество символов
s — String

Общий вид инструкции форматирования следующий:

%[argument_index$][flags][width][.precision]conversion

 % — специальный символ, обозначающий начало инструкций форматирования.
 [argument_index$] — целое десятичное число, указывающее позицию аргумента в списке аргументов. Ссылка на первый аргумент "1$", ссылка на второй аргумент "2$" и т.д. Не является обязательной частью инструкции. Если позиция не задана, то аргументы должны находиться в том же порядке, что и ссылки на них в строке форматирования.
[flags] — специальные символы для форматирования. Например, флаг "+" означает, что числовое значение должно включать знак +, флаг "-" означает выравнивание результата по левому краю, флаг «,» устанавливает разделитель тысяч у целых чисел. Не является обязательной частью инструкции.
[width] — положительное целое десятичное число, которое определяет минимальное количество символов, которые будут выведены.  Не является обязательной частью инструкции.
[.precision] — не отрицательное целое десятичное число с точкойперед ним. Обычно используется для ограничения количества символов. Специфика поведения зависит от вида преобразования. Не является обязательной частью инструкции.
conversion — это символ, указывающий, как аргумент должен быть отформатирован. Например d для целых чисел, s для строк, f для чисел с плавающей точкой. Является обязательной частью инструкции.
 */

/*

#2

public String substring();

Создаёт новую последовательность/строку с символами из данной строки начиная с позиции start до конца строки/заканчивая символом с позиции end.
Новая строка содержит символы от start до end - 1, поэтому берём на один символ больше.

String testString = "скотина";
infoTextView.setText(testString.substring(1, 4)); // возвращается кот
 */

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();

        if ("-c".equals(args[0])){
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String id = reader.readLine();
            while (reader.ready()){
                id = reader.readLine();
            }
            reader.close();

            id = id.substring(0,id.indexOf(" ")>=0 && id.indexOf(" ")<=7 ?id.indexOf(" "):8);
            int idInc = Integer.parseInt(id)+1;
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            if (productName.length()>30)
                productName = productName.substring(0,30);
            if (price.length()>8)
                price = price.substring(0,8);
            if (quantity.length()>4)
                quantity = quantity.substring(0,4);
            while (productName.length()<30){
                productName+=" ";
            }
            while (price.length()<8){
                price+=" ";
            }
            while (quantity.length()<4){
                quantity+=" ";
            }
            String outputString = String.valueOf(idInc)+productName+price+quantity;
            FileOutputStream outputStream = new FileOutputStream(fileName,true);
            outputStream.write(outputString.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}
