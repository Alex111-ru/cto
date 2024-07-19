package ru.roslikov.springcourse;

import org.springframework.stereotype.Component;

@Component
public class Goat extends Animal {

    public Goat() {
        super("Goat");
    }

    @Override
    public void sayBeforeDeath() {
        System.out.println("Bleat Bleat");
    }
}
