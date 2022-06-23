package com.example.controller;
import com.example.entity.Accauntt;
import com.example.service.LoginService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import javax.validation.Valid;

@Controller("/user")
public class LoginController {

    @Inject
    private LoginService loginService;


    @Post(value = "/login", consumes = MediaType.APPLICATION_JSON)
    public int login(@Body  Accauntt acaunt) {

        return loginService.getloginpass(acaunt.getLog(),acaunt.getPassword()) ;
    }
}
