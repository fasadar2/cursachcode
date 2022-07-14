package com.example.practic2.controller;

import com.example.practic2.ReqestModel.BasicReqestModel;
import com.example.practic2.ReqestModel.MachineReciveModel;
import com.example.practic2.ReqestModel.ServiceMachineReciveModel;
import com.example.practic2.ReqestModel.ServiceMachineUpdateReciveModel;
import com.example.practic2.model.ServiceMachineListModel;
import com.example.practic2.service.ServiceMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceMachineController {
    @Autowired
    ServiceMachineService service;

    @GetMapping(path = "/getServiceList")
    public List<ServiceMachineListModel> getServiceMachineList(){
        return service.serviceMachineListModels();
    }
    @PostMapping(path = "/NewServiceMachine",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasicReqestModel newServiceMachine(@RequestBody ServiceMachineReciveModel model){
        BasicReqestModel reqestModel = new BasicReqestModel();
        if(
                service.newServiceMachine(model.getStatus(), model.getMachineId(), model.getErrorId(), model.getTOEE(),model.getTOES())
        ){
            reqestModel.setCode(1);
            reqestModel.setMessage("Данные успешно обновлены");
        }else {
            reqestModel.setCode(2);
            reqestModel.setMessage("Проверьте ввод");
        }
        return reqestModel;
    }

    @PostMapping(path = "/UpdateServiceMachine",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasicReqestModel updateServiceMachine(@RequestBody ServiceMachineUpdateReciveModel model){
        BasicReqestModel reqestModel = new BasicReqestModel();
        if(
                service.updateServiceMachine(model.getStatus(), model.getId(), model.getTOES())
        ){
            reqestModel.setCode(1);
            reqestModel.setMessage("Данные успешно обновлены");
        }else {
            reqestModel.setCode(2);
            reqestModel.setMessage("Проверьте ввод");
        }
        return reqestModel;
    }

}
