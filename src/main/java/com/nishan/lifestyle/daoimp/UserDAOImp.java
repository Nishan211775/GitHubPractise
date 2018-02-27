/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.daoimp;

import com.nishan.lifestyle.entity.User;
import com.nishan.lifestyle.dao.UserDAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan
 */
@Repository(value = "genericDaoImp")
public class UserDAOImp extends GenericDAOImp<User> implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;
    private Query query;
    
    @Override
    public User login(String username, String password) {
        String hql = "Select u from User u where u.username=:username and u.password=:password";
        session = sessionFactory.openSession();
        
        try {
            query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);
        } catch(HibernateException e) {
            System.out.println(e);
            return null;
        }

        return (User) query.uniqueResult();
    }
}
