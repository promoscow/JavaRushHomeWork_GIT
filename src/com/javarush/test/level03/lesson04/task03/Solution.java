package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg1 = new Zerg();
        zerg1.name = "Lapochka";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Kotik";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Pidor";
        Zerg zerg4 = new Zerg();
        zerg4.name = "4mo";
        Zerg zerg5 = new Zerg();
        zerg5.name = "skjh";
        Zerg zerg6 = new Zerg();
        zerg6.name = "sgdrg";
        Zerg zerg7 = new Zerg();
        zerg7.name = "fjhfghgh";
        Zerg zerg8 = new Zerg();
        zerg8.name = "eg5e5";
        Zerg zerg9 = new Zerg();
        zerg9.name = "5greg5e";
        Zerg zerg10 = new Zerg();
        zerg10.name = "ge5rdgrdg5r";

        Protos protos1 = new Protos();
        protos1.name = "sldkjfghgierugh";
        Protos protos2 = new Protos();
        protos2.name = "sfdf";
        Protos protos3 = new Protos();
        protos3.name = "qqq";
        Protos protos4 = new Protos();
        protos4.name = "www";
        Protos protos5 = new Protos();
        protos5.name = "eee";

        Terran terran1 = new Terran();
        terran1.name = "rrr";
        Terran terran2 = new Terran();
        terran1.name = "ttt";
        Terran terran3 = new Terran();
        terran1.name = "rrry";
        Terran terran4 = new Terran();
        terran1.name = "rrru";
        Terran terran5 = new Terran();
        terran1.name = "rrri";
        Terran terran6 = new Terran();
        terran1.name = "rrro";
        Terran terran7 = new Terran();
        terran1.name = "rrrp";
        Terran terran8 = new Terran();
        terran1.name = "rrra";
        Terran terran9 = new Terran();
        terran1.name = "rrrs";
        Terran terran10 = new Terran();
        terran1.name = "rrrd";
        Terran terran11 = new Terran();
        terran1.name = "rrrf";
        Terran terran12 = new Terran();
        terran1.name = "rrrg";




    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}