package com.example.confectionery.dao;

import com.example.confectionery.model.Supplier;
import java.util.List;

public interface SupplierDao {
    void save(Supplier supplier);
    void update(Supplier supplier);
    void delete(Long id);
    Supplier findById(Long id);
    List<Supplier> findAll();
}