package com.example.controller;


import com.example.entity.Email;
import com.example.entity.ServiceMachine;
import com.example.model.ServiceMachineModel;
import com.example.service.CreateExelService;
import com.example.service.LoginService;
import com.example.service.SendFileService;
import com.example.service.ServiceMachineService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.sql.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Controller("/service")
public class ServiceMachineController {
    @Inject
    private ServiceMachineService serviceMachineService;
    @Inject
    private SendFileService send;

    @Inject
    private CreateExelService exel;
    @Inject
    private  LoginService login;

    @Post(value = "/machine", consumes = MediaType.APPLICATION_JSON)
    public int login(@Body ServiceMachine serviceMachine) {
        return serviceMachineService.GetId(
                serviceMachine.getId(),
                serviceMachine.getErrorid(),
                serviceMachine.getStatus(),
                serviceMachine.getToSS(),
                serviceMachine.getToES()
        );
    }

    @Post(value = "/updatemachine", consumes = MediaType.APPLICATION_JSON)
    public int update(@Body ServiceMachine serviceMachine) {

        return serviceMachineService.GetId2(
                serviceMachine.getId(),
                serviceMachine.getStatus(),
                serviceMachine.getToES()
        );
    }

    @Get(value = "/servicemachinelist")
    public ArrayList<ServiceMachineModel> table(){
        ArrayList<ServiceMachineModel> dfx = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
            String sql = "Select * From medicalservice.servicemachine join medicalservice.machine as mac on mac.id = servicemachine.machineid LEFT OUTER JOIN medicalservice.erorrmessage as error on error.id = servicemachine.errormessageid where engineerid = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(login.getPersonalId());
            ps.setInt(1,login.getPersonalId());
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ServiceMachineModel service = new ServiceMachineModel();
                service.setId(Integer.toString(resultSet.getInt("id")));
                service.setMessage(resultSet.getString("message"));
                service.setStatus(resultSet.getString("status"));
                service.setSerial(resultSet.getString("serial"));
                service.setDos(formatter.format(resultSet.getDate("dos")));
                if(resultSet.getDate("dose") != null){
                service.setDose(formatter.format(resultSet.getDate("dose")));}
                dfx.add(service);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        return dfx;

    }

    @Post(value = "/report", consumes = MediaType.APPLICATION_JSON)
    public int GetReport(@Body Email email) throws ParseException {
        exel.CreateExel();

        return send.SendEmail(email.getEmail());
    }

}
