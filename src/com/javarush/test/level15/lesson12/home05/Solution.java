package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.math.BigInteger;

public class Solution
{

    public Solution(String a)
    {
    }

    public Solution(int q)
    {
    }

    public Solution(boolean z)
    {
    }

    private Solution(double w)
    {
    }

    private Solution(long s)
    {
    }

    private Solution(float o)
    {
    }

    protected Solution(Object t)
    {
    }

    protected Solution(short i)
    {
    }

    protected Solution(char e)
    {
    }
    Solution(Integer k){}
    Solution(Double l){}
    Solution(BigInteger f){}
}

