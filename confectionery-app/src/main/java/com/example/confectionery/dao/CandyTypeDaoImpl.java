package com.example.confectionery.dao;

import com.example.confectionery.model.CandyType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class CandyTypeDaoImpl implements CandyTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(CandyType candyType) {
        sessionFactory.getCurrentSession().save(candyType);
    }

    @Override
    public void update(CandyType candyType) {
        sessionFactory.getCurrentSession().update(candyType);
    }

    @Override
    public void delete(Long id) {
        CandyType candyType = findById(id);
        if (candyType != null) {
            sessionFactory.getCurrentSession().delete(candyType);
        }
    }

    @Override
    public CandyType findById(Long id) {
        return sessionFactory.getCurrentSession().get(CandyType.class, id);
    }

    @Override
    public List<CandyType> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from CandyType", CandyType.class).list();
    }
}