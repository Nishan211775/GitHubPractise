/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.daoimp;

import com.nishan.lifestyle.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nishan
 * @param <T>
 */
    public abstract class GenericDAOImp<T> implements GenericDAO<T>{

    @Autowired
    private SessionFactory sessionFactroy;
    
    private Transaction trans;
    private Session session;
    
    private final Class<T> persistClass;
    
    public GenericDAOImp() {
        persistClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    @Override
    public void insert(T t) {
        session = sessionFactroy.openSession();
        trans = session.beginTransaction();
        
        try {
            session.save(t);
            trans.commit();
        } catch(HibernateException ex) {
            System.out.println(ex);
            trans.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T t) {
        session = sessionFactroy.openSession();
        trans = session.beginTransaction();
        
        try {
            session.update(t);
            trans.commit();
        } catch(HibernateException e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(T t) {
        session = sessionFactroy.openSession();
        trans = session.beginTransaction();
        
        try {
            session.delete(t);
            trans.commit();
        } catch(HibernateException ex) {
            System.out.println(ex);
            trans.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<T> getAll() {
        session = sessionFactroy.openSession();
        Criteria criteria = session.createCriteria(persistClass);
        return criteria.list();
    }

    @Override
    public T getById(int id) {
        session = sessionFactroy.openSession();
        T t = (T) session.get(persistClass, id);
        return t;
    }
    
}
