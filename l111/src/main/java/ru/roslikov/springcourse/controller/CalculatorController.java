package ru.roslikov.springcourse.controller;

import ru.roslikov.springcourse.model.Calculation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {

    private List<Calculation> history = new ArrayList<>();

    @RequestMapping("/")
    public String showForm(Model model) {
        model.addAttribute("history", history);
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("number1") double number1,
                            @RequestParam("number2") double number2,
                            @RequestParam("operation") String operation,
                            Model model) {
        double result = 0;
        switch (operation) {
            case "add":
                result = number1 + number2;
                break;
            case "subtract":
                result = number1 - number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    return "error"; // Обработка деления на ноль
                }
                break;
        }

        Calculation calculation = new Calculation(number1, number2, operation, result);
        history.add(calculation);

        model.addAttribute("result", result);
        model.addAttribute("history", history);
        return "calculator";
    }
}
