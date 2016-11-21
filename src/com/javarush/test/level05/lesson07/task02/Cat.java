package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String filename = null;
    private int weight = 8;
    private int age = 5;
    private String name = null;
    private String adress = null;
    private String color = "Black";

    public void initialize(String name)
    {
        this.filename = name;
    }
    public void initialize(String name, int weight, int age)
    {
        this.filename = name + weight + age;
    }
    public void initialize(String name, int age)
    {
        this.filename = name + age;
    }
    public void initialize(int weight, String color)
    {
        this.filename = weight + color;
    }
    public void initialize(int weight, String color, String adress)
    {
        this.filename = weight + color + adress;
    }

}
