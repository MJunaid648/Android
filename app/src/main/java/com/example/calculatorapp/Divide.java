package com.example.calculatorapp;
public class Divide
{

    double quotient;
    double remainder;
    String resultString;

    public String divide(double arg1, double arg2)
    {
        try
        {

            quotient = arg1/arg2;
            remainder = arg1 % arg2;

            resultString = String.valueOf(quotient) + " R: " + remainder;
        }
        catch (ArithmeticException e)
        {

            resultString = "Division by zero is not allowed.";
        }
        return resultString;
    }

}