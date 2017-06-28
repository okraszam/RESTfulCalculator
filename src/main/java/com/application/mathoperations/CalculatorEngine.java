package com.application.mathoperations;


import javax.ejb.Stateless;

@Stateless
public class CalculatorEngine {

    public float calculate (Enum operation, int firstInt, int secondInt) {

        if (operation.equals(Operations.ADD)) {
            Addition addition = new Addition();
            return addition.mathOperation(firstInt, secondInt);
        } else if (operation.equals(Operations.SUB)) {
            Subtraction subtraction = new Subtraction();
            return subtraction.mathOperation(firstInt, secondInt);
        } else if (operation.equals(Operations.MUL)) {
            Multiplication multiplication = new Multiplication();
            return multiplication.mathOperation(firstInt, secondInt);
        } else if (operation.equals(Operations.DIV)) {
            Division division = new Division();
            return division.mathOperation(firstInt, secondInt);
        } else {
            return 0f;
        }

    }

}
