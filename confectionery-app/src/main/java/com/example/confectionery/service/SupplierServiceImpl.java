package com.example.confectionery.service;

import com.example.confectionery.dao.SupplierDao;
import com.example.confectionery.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public void save(Supplier supplier) {
        supplierDao.save(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierDao.update(supplier);
    }

    @Override
    public void delete(Long id) {
        supplierDao.delete(id);
    }

    @Override
    public Supplier findById(Long id) {
        return supplierDao.findById(id);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierDao.findAll();
    }
}
