package com.example.confectionery.service;

import com.example.confectionery.dao.CandyDao;
import com.example.confectionery.model.Candy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandyServiceImpl implements CandyService {

    @Autowired
    private CandyDao candyDao;

    @Override
    public void save(Candy candy) {
        candyDao.save(candy);
    }

    @Override
    public void update(Candy candy) {
        candyDao.update(candy);
    }

    @Override
    public void delete(Long id) {
        candyDao.delete(id);
    }

    @Override
    public Candy findById(Long id) {
        return candyDao.findById(id);
    }

    @Override
    public List<Candy> findAll() {
        return candyDao.findAll();
    }
}