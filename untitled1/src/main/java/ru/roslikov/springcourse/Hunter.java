package ru.roslikov.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Hunter {
    private List<Animal> animals;

    @Autowired
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void killAnimal(String animalName) {
        for (Animal animal : animals) {
            if (animal.name.equals(animalName)) {
                System.out.println("Hunter is killing " + animal.name);
                animal.sayBeforeDeath();
                return;
            }
        }
        System.out.println("No animal with name " + animalName + " found");
    }
}