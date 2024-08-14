package com.example.confectionery.dao;

import com.example.confectionery.model.CandyType;
import java.util.List;

public interface CandyTypeDao {
    void save(CandyType candyType);
    void update(CandyType candyType);
    void delete(Long id);
    CandyType findById(Long id);
    List<CandyType> findAll();
}