package com.application.mathoperations;


public class Multiplication implements MathOperations {

    public float mathOperation(int firstInt, int secondInt) {

        float multiplicationResult = Float.valueOf(firstInt * secondInt);
        return multiplicationResult;

    }

}
