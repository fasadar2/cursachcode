package com.example.controller;
import com.example.entity.NewMachine;
import com.example.service.NewMachineService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/new")
public class NewMachineController {
    @Inject
    private NewMachineService newMachineService;

    @Post(value = "/machine", consumes = MediaType.APPLICATION_JSON)
    public int login(@Body NewMachine machine) {

        return newMachineService.GetId(
                machine.getMachine(),
                machine.getId(),
                machine.getRecomendation(),
                machine.getDateNTO(),
                machine.getDateDSE(),
                machine.getDateDEE()) ;
    }
}
