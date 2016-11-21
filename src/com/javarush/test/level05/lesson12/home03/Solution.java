package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);//объекты. в объектах указаны значения, которые будут присвоены переменным классов. Объекты принадлежат своим классам.

        Cat tomCat = new Cat("Tom", 20, 18);
        Dog bastardDog = new Dog("Bastard", 30, 7);
    }

    public static class Mouse//классы. в них будут созданы переменные, которым будут присвоены значения в конструкторах
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)//конструкторы. в них переменным классов будут присвоены значения
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog
    {
        String name;
        int height;
        int tail;

        public Dog(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        String name;
        int height;
        int tail;

        public Cat(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }


}
