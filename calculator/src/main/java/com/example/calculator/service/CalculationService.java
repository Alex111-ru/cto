package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double calculate(double num1, double num2, String operation) {
        double result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
                break;
        }
        return result;
    }
}
