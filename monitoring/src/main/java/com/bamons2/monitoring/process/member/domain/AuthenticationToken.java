package com.bamons2.monitoring.process.member.domain;

import java.util.Collection;

/**
 * Created by david100gom on 2017. 8. 22.
 *
 * Github : https://github.com/david100gom
 */
public class AuthenticationToken {

    private String username;
    private Collection authorities;
    private String token;

    public AuthenticationToken(String username, Collection collection, String token) {
        this.username = username;
        this.authorities = collection;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection authorities) {
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
