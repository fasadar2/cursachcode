package com.example.practic2.controller;

import com.example.practic2.ReqestModel.*;
import com.example.practic2.model.MachineListModel;
import com.example.practic2.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MachineController {
    @Autowired
    MachineService machineService;
    @GetMapping( path = "/machineTable")
    public List<MachineListModel> getMachineList(){
        return machineService.getMachineList();
    }

    @PostMapping(path = "/machineUpdateStatus",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasicReqestModel updateStatus(@RequestBody MachineStatusReqestModel machineStatusReqestModel){
        BasicReqestModel reqestModel = new BasicReqestModel();
        if(machineService.UpdateMachineStatus(machineStatusReqestModel.getSerial(), machineStatusReqestModel.getStatus())){
            reqestModel.setCode(1);
            reqestModel.setMessage("Данные успешно обновлены");
        }else {
            reqestModel.setCode(2);
            reqestModel.setMessage("Проверьте ввод");
        }
        return reqestModel;
    }
    @PostMapping(path = "/machineUpdateRecomendation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasicReqestModel updateRecomendation(@RequestBody MachineRecomendationReqestModel machineRecomendationReqestModel){
        BasicReqestModel reqestModel = new BasicReqestModel();
        if(machineService.UpdateMachineRecomendation(machineRecomendationReqestModel.getSerial(),
                machineRecomendationReqestModel.getRecomendation())){
            reqestModel.setCode(1);
            reqestModel.setMessage("Данные успешно обновлены");
        }else {
            reqestModel.setCode(2);
            reqestModel.setMessage("Проверьте ввод");
        }
        return reqestModel;
    }
    @PostMapping(path = "/machineTOUpdate",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasicReqestModel updateTO(@RequestBody MachineTOUpdateRequestModel machineTOUpdateRequestModel){
        BasicReqestModel reqestModel = new BasicReqestModel();
        if(machineService.UpdateLastServiceMachine(machineTOUpdateRequestModel.getSerial(),
                machineTOUpdateRequestModel.getDate())){
            reqestModel.setCode(1);
            reqestModel.setMessage("Данные успешно обновлены");
        }else {
            reqestModel.setCode(2);
            reqestModel.setMessage("Проверьте ввод");
        }
        return reqestModel;
    }
    @PostMapping(path = "/newMachine",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasicReqestModel NewMachine(@RequestBody MachineReciveModel model){
        BasicReqestModel reqestModel = new BasicReqestModel();
        if(
                machineService.NewMachine(model.getSerial(), model.getDateNTO(),model.getDSE(),model.getDEE(), model.getRecomendation(), model.getType())
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
