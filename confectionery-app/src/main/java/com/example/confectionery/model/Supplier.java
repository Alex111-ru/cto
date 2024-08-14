package com.example.confectionery.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_name")
    private String organizationName;

    private String address;

    @OneToMany(mappedBy = "supplier")
    private Set<Candy> candies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and Setters
}
