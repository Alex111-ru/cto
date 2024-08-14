package com.example.confectionery.dao;

import com.example.confectionery.model.Owner;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class OwnerDaoImpl implements OwnerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Owner owner) {
        sessionFactory.getCurrentSession().save(owner);
    }

    @Override
    public void update(Owner owner) {
        sessionFactory.getCurrentSession().update(owner);
    }

    @Override
    public void delete(Long id) {
        Owner owner = findById(id);
        if (owner != null) {
            sessionFactory.getCurrentSession().delete(owner);
        }
    }

    @Override
    public Owner findById(Long id) {
        return sessionFactory.getCurrentSession().get(Owner.class, id);
    }

    @Override
    public List<Owner> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Owner", Owner.class).list();
    }
}