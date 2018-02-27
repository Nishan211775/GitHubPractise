/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.entity;

import java.util.Date;

/**
 *
 * @author Nishan
 */
public class RefreshToken {
    private String value;
    private Date expiration;
    
    public RefreshToken() {
    }

    public RefreshToken(String value, Date expiration) {
        this.value = value;
        this.expiration = expiration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
 
    
}
