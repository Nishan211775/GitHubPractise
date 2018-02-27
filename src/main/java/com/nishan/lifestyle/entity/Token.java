/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.lifestyle.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nishan
 */
public class Token {
    private String value;
    private Date expiration;
    private String tokenType;
    private List<RefreshToken> refreshToken;

    public Token(String value, Date expiration, String tokenType, List<RefreshToken> refreshToken) {
        this.value = value;
        this.expiration = expiration;
        this.tokenType = tokenType;
        this.refreshToken = refreshToken;
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

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public List<RefreshToken> getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(List<RefreshToken> refreshToken) {
        this.refreshToken = refreshToken;
    }
    
    
}
