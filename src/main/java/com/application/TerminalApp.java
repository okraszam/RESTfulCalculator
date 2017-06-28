package com.application;


import com.application.mathoperations.CalculatorEngine;
import static com.application.mathoperations.Operations.*;


public class TerminalApp {

    public static void main(String[] args) {

        Enum choosenMathOperation = DIV;
        int firstInt = 7;
        int secondInt = 14;

        CalculatorEngine calculatorEngine = new CalculatorEngine();
        System.out.println(calculatorEngine.calculate(choosenMathOperation, firstInt, secondInt));

    }

}
