package com.example.practic2.service;

import com.example.practic2.DAO.LoginDataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogCheckService {
    @Autowired
    LoginDataDAO loginDataDAO;

    public boolean CheckLogin(String login,String password){
        return loginDataDAO.ConfirmLogPass(login,password);
    }
}
