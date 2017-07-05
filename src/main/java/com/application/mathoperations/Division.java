package com.application.mathoperations;


public class Division implements MathOperations {

    public float mathOperation (Integer firstInt, Integer secondInt) {

        if (secondInt != 0) {
            float divisionResult = Float.valueOf(firstInt) / Float.valueOf(secondInt);
            return divisionResult;
        } else {
            return 0f;
        }

    }

}
