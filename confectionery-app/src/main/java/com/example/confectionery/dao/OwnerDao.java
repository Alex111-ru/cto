package com.example.confectionery.dao;


import com.example.confectionery.model.Owner;
import java.util.List;

public interface OwnerDao {
    void save(Owner owner);
    void update(Owner owner);
    void delete(Long id);
    Owner findById(Long id);
    List<Owner> findAll();
}