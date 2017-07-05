package com.application.mathoperations;


public class Subtraction implements MathOperations {

    public float mathOperation(Integer firstInt, Integer secondInt) {

        float subtractionResut = Float.valueOf(firstInt - secondInt);
        return subtractionResut;

    }

}
