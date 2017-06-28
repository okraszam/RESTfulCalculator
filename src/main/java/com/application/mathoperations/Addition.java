package com.application.mathoperations;


public class Addition implements MathOperations {

    public float mathOperation(int firstInt, int secondInt) {

        float additionResult = Float.valueOf(firstInt + secondInt);
        return additionResult;

    }
}
