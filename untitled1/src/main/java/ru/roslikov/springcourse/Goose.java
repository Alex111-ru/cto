package ru.roslikov.springcourse;

import org.springframework.stereotype.Component;

@Component
public class Goose extends Animal {

    public Goose() {
        super("Goose");
    }

    @Override
    public void sayBeforeDeath() {
        System.out.println("Honk Honk");
    }
}
