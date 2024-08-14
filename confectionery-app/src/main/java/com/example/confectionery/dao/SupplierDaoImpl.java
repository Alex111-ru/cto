package com.example.confectionery.dao;

import com.example.confectionery.model.Supplier;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Supplier supplier) {
        sessionFactory.getCurrentSession().save(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        sessionFactory.getCurrentSession().update(supplier);
    }

    @Override
    public void delete(Long id) {
        Supplier supplier = findById(id);
        if (supplier != null) {
            sessionFactory.getCurrentSession().delete(supplier);
        }
    }

    @Override
    public Supplier findById(Long id) {
        return sessionFactory.getCurrentSession().get(Supplier.class, id);
    }

    @Override
    public List<Supplier> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Supplier", Supplier.class).list();
    }
}
