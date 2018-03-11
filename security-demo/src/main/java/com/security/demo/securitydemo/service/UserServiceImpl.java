package com.security.demo.securitydemo.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String getUserName(String name) {
        return name;
    }
}
