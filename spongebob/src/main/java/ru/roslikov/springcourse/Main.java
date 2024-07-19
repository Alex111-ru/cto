package ru.roslikov.springcourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person spongeBob = (Person) context.getBean("spongeBob");
        Person patrick = (Person) context.getBean("patrick");
        Person squidward = (Person) context.getBean("squidward");

        System.out.println(spongeBob);
        System.out.println(patrick);
        System.out.println(squidward);
    }

    }
