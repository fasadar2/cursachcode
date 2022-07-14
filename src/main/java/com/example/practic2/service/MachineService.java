package com.example.practic2.service;

import com.example.practic2.model.MachineListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@Service
public class MachineService {
    @Autowired
    com.example.practic2.DAO.MachineDAO machineDAO;



    public List<MachineListModel> getMachineList(){
        return machineDAO.setMachineRepository();
}
    public boolean updateMachineStatus(Integer serial,String status){
        boolean request = false;
        if(serial != null){
            machineDAO.setStatusMachine(serial,status);
            request = true;
        }else {
            request = false;
        }
        return request;
    }

    public boolean updateMachineRecomendation(Integer serial,String recomendation){
        boolean request = false;
        if(serial != null){
            machineDAO.setRecomendationMachine(serial,recomendation);
            request = true;
        }else {
            request = false;
        }
        return request;
    }
    public boolean updateLastServiceMachine(Integer serial, LocalDate date){
        boolean request = false;
        if(serial != null){
            machineDAO.setLastTo(serial,date);
            request = true;
        }else {
            request = false;
        }
        return request;
    }
    public boolean newMachine(Integer serial, LocalDate dateNTO,LocalDate DSE,LocalDate DEE,String recomendation,String type){
        boolean request = false;
        if(serial != null){
            machineDAO.newMachine(serial, type, recomendation, DSE, DEE, dateNTO);
            request = true;
        }else {
            request = false;
        }
        return request;
    }
}
