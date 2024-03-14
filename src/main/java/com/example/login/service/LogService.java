package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.domain.Login;
import com.example.login.repository.LogRepo;

@Service
public class LogService {

    @Autowired
     private LogRepo rep;

    public Login log(String username , String password){
        Login user = rep.findByUsernameAndPassword(username, password);
        return user;
    }


}
