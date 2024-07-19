package ru.roslikov.springcourse;

import org.springframework.stereotype.Component;

@Component
public class Frog extends Animal {

    public Frog() {
        super("Frog");
    }

    @Override
    public void sayBeforeDeath() {
        System.out.println("Kva kva ");
    }
}
