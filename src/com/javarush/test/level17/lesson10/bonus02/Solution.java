package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args.length > 0) {
            switch (args[0]) {
                case "-c" : {
                    int nextIdBeginning = 1;
                    String fullName;
                    int sexIndex;
                    Date date;
                    for (int i = 1; i < args.length; i++) {
                        if (args[i].contains("/")) {
                            StringBuilder stringbuilder = new StringBuilder();
                            for (int j = nextIdBeginning; j < (i - 1); j++) {
                                stringbuilder.append(args[j]);
                                stringbuilder.append(" ");
                            }
                            fullName = stringbuilder.toString().trim();         //имя
                            sexIndex = i - 1;           //пол
                            date = format.parse(args[i]);          //дата рождения
                            if (args[sexIndex].equals("м"))
                            {
                                allPeople.add(Person.createMale(fullName, date));
                            } else if (args[sexIndex].equals("ж"))
                            {
                                allPeople.add(Person.createFemale(fullName, date));
                            }
                            System.out.println(allPeople.size()-1);
                            nextIdBeginning = i + 1;
                        }
                    }
                }
                break;
                case "-u" : {
                    int nextIdBeginning = 1;
                    String fullName;
                    int sexIndex;
                    Date date;
                    for (int i = 1; i < args.length; i++) {
                        if (args[i].contains("/")) {
                            StringBuilder stringbuilder = new StringBuilder();
                            for (int j = nextIdBeginning + 1; j < (i - 1); j++) {
                                stringbuilder.append(args[j]);
                                stringbuilder.append(" ");
                            }
                            fullName = stringbuilder.toString().trim();         //имя
                            sexIndex = i - 1;           //пол
                            date = format.parse(args[i]);          //дата рождения
                            int id = Integer.parseInt(args[nextIdBeginning]);
                            allPeople.get(id).setName(fullName);
                            if (args[sexIndex].equals("м")) {
                                allPeople.get(id).setSex(Sex.MALE);
                            } else if (args[sexIndex].equals("ж")) {
                                allPeople.get(id).setSex(Sex.FEMALE);
                            }
                            allPeople.get(id).setBirthDay(date);
                            nextIdBeginning = i + 1;
                        }
                    }
                }
                break;
                case "-d" : {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDay(null);
                    }
                }
                break;
                case "-i" : {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        String sex;
                        if (allPeople.get(id).getSex().toString().equals("MALE")) sex = "м";
                        else sex = "ж";
                        System.out.println(allPeople.get(id).getName() + " " + sex + " " + df.format(allPeople.get(id).getBirthDay()));
                    }
                }
                break;
            }
        }
    }
}
