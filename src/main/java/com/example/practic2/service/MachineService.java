package com.example.practic2.service;

import com.example.practic2.model.MachineListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MachineService {
    @Autowired
    com.example.practic2.DAO.MachineDAO machineDAO;



    public List<MachineListModel> getMachineList(){
        return machineDAO.setMachineRepository();
}
    public boolean UpdateMachineStatus(Integer serial,String status){
        boolean request = false;
        if(serial != null){
            machineDAO.SetStatusMachine(serial,status);
            request = true;
        }else {
            request = false;
        }
        return request;
    }

    public boolean UpdateMachineRecomendation(Integer serial,String recomendation){
        boolean request = false;
        if(serial != null){
            machineDAO.SetRecomendationMachine(serial,recomendation);
            request = true;
        }else {
            request = false;
        }
        return request;
    }
    public boolean UpdateLastServiceMachine(Integer serial, LocalDate date){
        boolean request = false;
        if(serial != null){
            machineDAO.SetLastTo(serial,date);
            request = true;
        }else {
            request = false;
        }
        return request;
    }
    public boolean NewMachine(Integer serial, LocalDate dateNTO,LocalDate DSE,LocalDate DEE,String recomendation,String type){
        boolean request = false;
        if(serial != null){
            machineDAO.NewMachine(serial, type, recomendation, DSE, DEE, dateNTO);
            request = true;
        }else {
            request = false;
        }
        return request;
    }
}
