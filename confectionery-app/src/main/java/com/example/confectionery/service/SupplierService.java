package com.example.confectionery.service;

import com.example.confectionery.model.Supplier;
import java.util.List;

public interface SupplierService {
    void save(Supplier supplier);
    void update(Supplier supplier);
    void delete(Long id);
    Supplier findById(Long id);
    List<Supplier> findAll();
}