package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private double weight;
        private short ident;
        private double height;

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        public Human(boolean sex, short ident, double height)
        {
            this.sex = sex;
            this.height = height;
            this.ident = ident;
        }
        public Human(String name)
        {
            this.name = name;
        }
        public Human(double height, int age)
        {
            this.height = height;
            this.age = age;
        }
        public Human(double weight, double height)
        {
            this.weight = weight + height;
        }
        public Human(boolean sex)
        {
            this.sex = sex;
        }
        public Human(int age)
        {
            this.age = age;
        }
        public Human(short ident)
        {
            this.ident = ident;
        }
        public Human(double height)
        {
            this.height = height;
        }
        public Human(String name, int age, boolean sex, double weight)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
        }
    }
}
