package com.example.controller;


import com.example.entity.MachineID;
import com.example.entity.Recomendation;
import com.example.service.MachineIDService;
import com.example.service.UpdateRecomendationService;
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
    @Inject
    private UpdateRecomendationService updateRecomendationService;

    @Post(value = "/status", consumes = MediaType.APPLICATION_JSON)
    public int PostMachineStatus(@Body  MachineID machineID) {

        return machineIDService.GetId(machineID.getMachineID(), machineID.getIs()) ;
    }
    @Post(value = "/recomendation",consumes = MediaType.APPLICATION_JSON)
    public int recomendation(@Body Recomendation rec){
        return updateRecomendationService.Update(rec.getSerial(), rec.getRecomendation());
    }
}
