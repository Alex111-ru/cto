package ru.roslikov.springcourse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Создание контекста Spring из XML-конфигурации
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Получение бина Hunter из контекста
        Hunter hunter = context.getBean(Hunter.class);

        // Указание имен животных для убийства
        hunter.killAnimal("Goose");
        hunter.killAnimal("Goat");
        hunter.killAnimal("Frog");
    }
}