package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(2.5, "sdgfdg");
        labels.put(3.5, "sdgfdg");
        labels.put(6.5, "sdgfdg");
        labels.put(7.5, "sdgfdg");
        labels.put(8.5, "sdgfdg");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
