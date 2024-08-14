package com.example.confectionery.dao;

import com.example.confectionery.model.Candy;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository

public class CandyDaoImpl implements CandyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Candy candy) {
        sessionFactory.getCurrentSession().save(candy);
    }

    @Override
    public void update(Candy candy) {
        sessionFactory.getCurrentSession().update(candy);
    }

    @Override
    public void delete(Long id) {
        Candy candy = findById(id);
        if (candy != null) {
            sessionFactory.getCurrentSession().delete(candy);
        }
    }

    @Override
    public Candy findById(Long id) {
        return sessionFactory.getCurrentSession().get(Candy.class, id);
    }

    @Override
    public List<Candy> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Candy", Candy.class).list();
    }
}