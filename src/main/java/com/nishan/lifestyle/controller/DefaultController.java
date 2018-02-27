/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.controller;

import com.nishan.lifestyle.entity.User;
import com.nishan.lifestyle.service.UserService;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Nishan
 */
@Controller
//@CrossOrigin(origins = "http://localhost:4200")
public class DefaultController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        try {
            userService.insert(user);
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
    public ResponseEntity<User> login(@PathVariable String username, @PathVariable String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            
            User user = userService.login(username, password);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        List<User> list = userService.getAll();
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<List<User>> delete(@PathVariable int id) {
        if (id == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            User t = userService.getById(id);
            userService.delete(t);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@RequestBody User user) {
        try {;
            userService.update(user);
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
