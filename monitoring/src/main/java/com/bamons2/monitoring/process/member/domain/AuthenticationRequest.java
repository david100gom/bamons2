package com.bamons2.monitoring.process.member.domain;

/**
 * Created by david100gom on 2017. 8. 22.
 *
 * Github : https://github.com/david100gom
 */
public class AuthenticationRequest {

    private String username;
    private String password;

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
