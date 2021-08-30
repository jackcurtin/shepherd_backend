package com.example.shepherd.security;

import java.util.Collection;
import java.util.HashSet;

import com.example.shepherd.models.Account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
    private Account account;

    public MyUserDetails(Account account){
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return new HashSet<GrantedAuthority>();
    }

    @Override
    public String getPassword(){
        return account.getPassword();
    }

    @Override
    public String getUsername(){
        return account.getEmailAddress();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Account getAccount() {
        return account;
    }
}
