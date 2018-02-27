/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.service;

import com.nishan.lifestyle.entity.User;
import com.nishan.lifestyle.daoimp.UserDAOImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan
 */

@Service(value = "userDetailService")
public class UserService implements GenericService<User>{
    
    @Autowired
    UserDAOImp userDaoImp;

    @Override
    public void insert(User t) {
        userDaoImp.insert(t);
    }

    @Override
    public void update(User t) {
        userDaoImp.update(t);
    }

    @Override
    public void delete(User t) {
        userDaoImp.delete(t);
    }

    @Override
    public List<User> getAll() {
        return userDaoImp.getAll();
    }

    @Override
    public User getById(int id) {
        return userDaoImp.getById(id);
    }
    
    public User login(String username, String password) {
        return userDaoImp.login(username, password);
    }
    
}
