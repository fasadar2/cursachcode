package com.example.practic2.DAO;

import com.example.practic2.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDataDAO {
    @Autowired
    LoginRepository logrepos;
    public boolean confirmLogPass(String login, String password){
        boolean request = false;
        if(!logrepos.findDatelogByLoginAndPassword(login,password).isEmpty()){request= true; }
        else{request =  false; }
        return request;

    }
}
