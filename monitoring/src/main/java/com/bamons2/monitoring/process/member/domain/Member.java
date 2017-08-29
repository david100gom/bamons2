package com.bamons2.monitoring.process.member.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by david100gom on 2017. 8. 19.
 *
 * Github : https://github.com/david100gom
 */
@Entity
@Table(name="MEMBER")
public class Member implements UserDetails {

    @Id
    private String username;    // 아이디 (PK)
    @Column
    private String password;    // 패스워드
    @Column
    private String name;        // 이름

    @Column(name="isAccountNonExpired")
    private boolean isAccountNonExpired;        //  계정 만료여부

    @Column(name="isAccountNonLocked")
    private boolean isAccountNonLocked;         //  계정 잠금여부

    @Column(name="isCredentialsNonExpired")
    private boolean isCredentialsNonExpired;    //  패스워드 만료

    @Column(name="isEnabled")
    private boolean isEnabled;                  //  계정활성화 여부

    @Transient
    private Collection<? extends GrantedAuthority> authorities; // 권한

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
