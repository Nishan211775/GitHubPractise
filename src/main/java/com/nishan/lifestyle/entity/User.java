/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Nishan
 */
@Entity
@Table(name = "dbo.tbl_user", catalog = "lifestyle", schema = "")
@NamedQueries({
    @NamedQuery(name = "User.finAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE userId=:userId"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE fullName=:fullName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE email=:email"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE address=:address"),
    @NamedQuery(name = "User.findByContact", query = "SELECT u FROM User u WHERE contact=:contact"),
    @NamedQuery(name = "User.findByDOB", query = "SELECT u FROM User u WHERE dob=:dob"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE active=:active"),
    @NamedQuery(name = "User.findByCreatedAt", query = "SELECT u FROM User u WHERE createdAt=:createdAt"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE username=:username")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "contact")
    private String contact;
    
    @Column(name = "date_of_birth")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dob;
    
    @Column(name = "active", insertable = false)
    private boolean active;
    
    @Column(name = "created_at", insertable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    public User() {
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, String fullName, String email, String address, String contact, Date dob, boolean active, Date createdAt, String username, String password) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.active = active;
        this.createdAt = createdAt;
        this.username = username;
        this.password = password;
    }

    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
