package com.example.confectionery.service;

import com.example.confectionery.dao.CandyTypeDao;
import com.example.confectionery.model.CandyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandyTypeServiceImpl implements CandyTypeService {

    @Autowired
    private CandyTypeDao candyTypeDao;

    @Override
    public void save(CandyType candyType) {
        candyTypeDao.save(candyType);
    }

    @Override
    public void update(CandyType candyType) {
        candyTypeDao.update(candyType);
    }

    @Override
    public void delete(Long id) {
        candyTypeDao.delete(id);
    }

    @Override
    public CandyType findById(Long id) {
        return candyTypeDao.findById(id);
    }//тут бы обработать ситуацию если ничего не нашли

    @Override
    public List<CandyType> findAll() {
        return candyTypeDao.findAll();
    }
}