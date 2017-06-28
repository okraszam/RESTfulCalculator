package com.application.mathoperations;


public class Subtraction implements MathOperations {

    public float mathOperation(int firstInt, int secondInt) {

        float subtractionResut = Float.valueOf(firstInt - secondInt);
        return subtractionResut;

    }

}
