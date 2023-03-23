package week03;

import week03.calculator.Calculator;

public class Week03
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("2 + 3"));
        System.out.println(calculator.calculate("2.5 + 3"));
        System.out.println(calculator.calculate("2 - 3"));
        System.out.println(calculator.calculate("2 - 3 + 9"));
        System.out.println(calculator.calculate("2 t 3"));
        System.out.println(calculator.calculate("2 + g"));
    }
}
