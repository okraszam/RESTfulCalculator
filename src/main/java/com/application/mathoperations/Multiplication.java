package com.application.mathoperations;


public class Multiplication implements MathOperations {

    public float mathOperation(Integer firstInt, Integer secondInt) {

        float multiplicationResult = Float.valueOf(firstInt * secondInt);
        return multiplicationResult;

    }

}
