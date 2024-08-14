package com.example.confectionery.service;


import com.example.confectionery.model.Owner;
import java.util.List;

public interface OwnerService {
    void save(Owner owner);
    void update(Owner owner);
    void delete(Long id);
    Owner findById(Long id);
    List<Owner> findAll();
}