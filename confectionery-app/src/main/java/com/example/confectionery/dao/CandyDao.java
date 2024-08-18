package com.example.confectionery.dao;

import com.example.confectionery.model.Candy;
import java.util.List;

public interface CandyDao {
    void save(Candy candy);//в save надо возвращать сохраненное значение
    void update(Candy candy);//аналогично надо возвращать
    void delete(Long id);
    Candy findById(Long id);
    List<Candy> findAll();
}
