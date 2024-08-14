package com.example.confectionery.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "candy_type")
public class CandyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "candyType")
    private Set<Candy> candies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
