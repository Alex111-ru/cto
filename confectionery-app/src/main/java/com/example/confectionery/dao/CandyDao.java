package com.example.confectionery.dao;

import com.example.confectionery.model.Candy;
import java.util.List;

public interface CandyDao {
    void save(Candy candy);
    void update(Candy candy);
    void delete(Long id);
    Candy findById(Long id);
    List<Candy> findAll();
}
