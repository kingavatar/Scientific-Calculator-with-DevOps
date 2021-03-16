package com.github.kingavatar.scientificcalculator;

public class Calculator {

    private static final String message = "Welcome to the Calculator CLI Application";
    Calculator(){
        
    }

    @Override
    public String toString() {
        return message;
    }

    public double SquareRoot(double num){return num;}
    public int Factorial(int num){return num;}
    public double Log (double num){return num;}
    public double Pow(double num1, int num2){return num1;}
}
