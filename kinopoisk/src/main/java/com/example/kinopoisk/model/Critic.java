package com.example.kinopoisk.model;

// импорт с звездочкой плохо
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "critics")
public class Critic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // над полями лучше явно указывать имя @Column(name = "first_name")
    @Column(name = "first_name")
    private String firstName;

    private String lastName;

    @Column(length = 1000)
    private String info;

    @OneToMany(mappedBy = "critic")
    private List<Review> reviews;

    // Надо использовать Lombok с @Getter и @Setter
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
