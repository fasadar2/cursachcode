package com.example.controller;


import com.example.entity.MachineID;
import com.example.service.MachineIDService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import javax.validation.Valid;

@Controller("/machine")
public class MachineStatusController {
    @Inject
    private MachineIDService machineIDService;

    @Post(value = "/status", consumes = MediaType.APPLICATION_JSON)
    public int login(@Body  MachineID machineID) {

        return machineIDService.GetId(machineID.getMachineID(), machineID.getIs()) ;
    }
}
