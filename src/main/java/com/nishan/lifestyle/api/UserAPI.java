/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.api;

import com.nishan.lifestyle.entity.User;
import com.nishan.lifestyle.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Nishan
 */
@Controller
@RequestMapping(value = "/api/customer")
public class UserAPI {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> getAll(@RequestHeader String header) {
        List<User> list = userService.getAll();
        
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.println(header);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        userService.insert(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> insert(@PathVariable int id) {
        if (id == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userService.getById(id);
        userService.delete(user);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
