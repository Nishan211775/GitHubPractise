/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.dao;

import com.nishan.lifestyle.entity.User;

/**
 *
 * @author Nishan
 */
public interface UserDAO extends GenericDAO<User> {
    public User login(String username, String password);
}
