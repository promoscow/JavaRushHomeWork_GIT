package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();
    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args.length > 0)
        {
            switch (args[0])
            {
                case "-c": {
                    Date date = format.parse(args[args.length-1]);
                    StringBuilder stringbuilder = new StringBuilder();
                    for (int i = 1; i < (args.length - 2); i++) {
                        stringbuilder.append(args[i]);
                        stringbuilder.append(" ");
                    }
                    int sexNum = args.length - 2;
                    String fullName = stringbuilder.toString().trim();
                    if (args[sexNum].equals("м"))
                    {
                        allPeople.add(Person.createMale(fullName, date));
                    } else if (args[sexNum].equals("ж"))
                    {
                        allPeople.add(Person.createFemale(fullName, date));
                    }
                    System.out.println(allPeople.size()-1);

                }
                    break;
                case "-u": {
                    int id = Integer.parseInt(args[1]);
                    Date date = format.parse(args[args.length-1]);
                    StringBuilder stringbuilder = new StringBuilder();
                    for (int i = 2; i < (args.length - 2); i++) {
                        stringbuilder.append(args[i]);
                        stringbuilder.append(" ");
                    }
                    int sexNum = args.length - 2;
                    String fullName = stringbuilder.toString().trim();
                    allPeople.get(id).setName(fullName);
                    if (args[sexNum].equals("м")) {
                        allPeople.get(id).setSex(Sex.MALE);
                    } else if (args[sexNum].equals("ж")) {
                        allPeople.get(id).setSex(Sex.FEMALE);
                    }
                    allPeople.get(id).setBirthDay(date);
                }
                    break;
                case "-d": {
                    int id = Integer.parseInt(args[1]);
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setSex(null);
                    allPeople.get(id).setBirthDay(null);

                }
                    break;
                case "-i": {
                    int id = Integer.parseInt(args[1]);
                    String sex;
                    if (allPeople.get(id).getSex().toString().equals("MALE")) sex = "м";
                    else sex = "ж";
                    System.out.println(allPeople.get(id).getName() + " " + sex + " " + df.format(allPeople.get(id).getBirthDay()));
                }
                    break;
            }
        }
    }
}
