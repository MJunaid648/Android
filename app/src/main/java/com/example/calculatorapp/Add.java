package com.example.calculatorapp;
public class Add {

    double sum;

    public String add (double arg1, double arg2)
    {
        sum = arg1 + arg2;
        return String.valueOf(sum);
    }

   /* public String getResultString() {
        return String.valueOf(sum);
    }*/
}