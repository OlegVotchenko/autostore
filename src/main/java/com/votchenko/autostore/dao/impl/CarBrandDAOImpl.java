package com.votchenko.autostore.dao.impl;

import com.votchenko.autostore.dao.CarBrandDAO;
import com.votchenko.autostore.entities.CarBrand;
import com.votchenko.autostore.enums.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;
import java.util.Optional;


public class CarBrandDAOImpl implements CarBrandDAO {

    private SessionFactory sessionFactory;

    public CarBrandDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CarBrand> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from CarBrand", CarBrand.class).list();
    }

    @Override
    public List<CarBrand> findAll(int pageSize, int pageNumber) {
        Session session = sessionFactory.openSession();
        return session.createQuery("from CarBrand", CarBrand.class)
                .setMaxResults(pageSize).setFirstResult((pageNumber-1)*pageSize).list();
    }

    @Override
    public void save(CarBrand entity) {
        this.sessionFactory.openSession().save(entity);
    }

    @Override
    public boolean update(CarBrand entity) {
        this.sessionFactory.openSession().update(entity);
        return true;
    }

    @Override
    public Result delete(long id) {
        Transaction transaction = null;
        try {
            Session session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            int result = session.createQuery("delete from CarBrand as p where p.id=:id")
                    .setParameter("id", id).executeUpdate();
            transaction.commit();
            return result > 0 ? Result.SUCCESS : Result.NOT_FOUND;
        }
        catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
            return Result.ERROR;
        }
    }

    @Override
    public Optional<CarBrand> findById(long id) {
        Session session = this.sessionFactory.openSession();
        CarBrand carBrand = session.get(CarBrand.class, id);

        return Optional.ofNullable(carBrand);
    }
}
