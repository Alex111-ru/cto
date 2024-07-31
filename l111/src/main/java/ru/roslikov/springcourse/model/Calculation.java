package ru.roslikov.springcourse.model;

public class Calculation {
    private double number1;
    private double number2;
    private String operation;
    private double result;

    public Calculation(double number1, double number2, String operation, double result) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }

    // Геттеры
    public double getNumber1() { return number1; }
    public double getNumber2() { return number2; }
    public String getOperation() { return operation; }
    public double getResult() { return result; }
}

