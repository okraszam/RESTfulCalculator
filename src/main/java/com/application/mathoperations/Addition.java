package com.application.mathoperations;


public class Addition implements MathOperations {

    public float mathOperation(Integer firstInt, Integer secondInt) {

        float additionResult = Float.valueOf(firstInt + secondInt);
        return additionResult;

    }
}
