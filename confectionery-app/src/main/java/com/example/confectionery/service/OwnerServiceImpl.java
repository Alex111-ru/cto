package com.example.confectionery.service;

import com.example.confectionery.dao.OwnerDao;
import com.example.confectionery.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerDao ownerDao;

    @Override
    public void save(Owner owner) {
        ownerDao.save(owner);
    }

    @Override
    public void update(Owner owner) {
        ownerDao.update(owner);
    }

    @Override
    public void delete(Long id) {
        ownerDao.delete(id);
    }

    @Override
    public Owner findById(Long id) {
        return ownerDao.findById(id);
    }

    @Override
    public List<Owner> findAll() {
        return ownerDao.findAll();
    }
}