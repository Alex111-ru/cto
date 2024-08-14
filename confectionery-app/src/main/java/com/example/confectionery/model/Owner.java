package com.example.confectionery.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "owner")
    private Set<Candy> candies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and Setters
}