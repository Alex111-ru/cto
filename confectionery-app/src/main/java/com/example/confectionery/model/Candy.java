package com.example.confectionery.model;


import javax.persistence.*;

@Entity
@Table(name = "candy")
public class Candy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer calories;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "candy_type_id")
    private CandyType candyType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}