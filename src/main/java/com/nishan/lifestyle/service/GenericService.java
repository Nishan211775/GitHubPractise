/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.service;

import java.util.List;

/**
 *
 * @author Nishan
 */
public interface GenericService<T> {
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public List<T> getAll();
    public T getById(int id);
}
