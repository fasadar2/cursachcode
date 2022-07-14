package com.example.practic2.controller;

import com.example.practic2.ReqestModel.BasicReqestModel;
import com.example.practic2.ReqestModel.LoginReqestModel;
import com.example.practic2.service.LogCheckService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LogCheckService logCheckService;

    @PostMapping(path = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasicReqestModel checkLogin(@RequestBody LoginReqestModel loginReqestModel){
        BasicReqestModel reqestModel = new BasicReqestModel();
        if(logCheckService.checkLogin(loginReqestModel.getLogin(), loginReqestModel.getPassword())){
            reqestModel.setCode(1);
            reqestModel.setMessage("Вход успешен");
        }else {
            reqestModel.setCode(2);
            reqestModel.setMessage("Вход не удался проверьте ввод данных");
        }
        return reqestModel;
    }
}
