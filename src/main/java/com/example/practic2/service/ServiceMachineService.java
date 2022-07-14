package com.example.practic2.service;

import com.example.practic2.DAO.ServiceMachineDAO;
import com.example.practic2.model.ServiceMachineListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceMachineService {
    @Autowired
    ServiceMachineDAO serviceMachineDAO;

    public List<ServiceMachineListModel> serviceMachineListModels(){
        return serviceMachineDAO.serviceMachineListModels();
    }
   public boolean  newServiceMachine(String status, Integer id, Integer errorId, LocalDate TOSS, LocalDate TOES){
       boolean request = false;
       if(id != null){
           serviceMachineDAO.newMachineService(status, id, errorId, TOSS, TOES);
           request = true;
       }else {
           request = false;
       }
       return request;
   }
    public boolean  updateServiceMachine(String status, Integer id,  LocalDate TOES){
        boolean request = false;
        if(id != null){
            serviceMachineDAO.updateServicemachine(status, id, TOES);
            request = true;
        }else {
            request = false;
        }
        return request;
    }


}
