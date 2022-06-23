package com.example.controller;

import com.example.model.MachineListModel;
import com.example.service.GreetingService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.lang.reflect.Array;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller("/get")
public class GetMachineListController {


    @Get("/machinelist")
    public ArrayList<MachineListModel> greet() {

         ArrayList<MachineListModel> dfx = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
            String sql = "Select * From medicalservice.machine join medicalservice.machinetype as mact on mact.id = machine.typeid";
            PreparedStatement ps = conn.prepareStatement(sql);
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MachineListModel machine = new MachineListModel();
               machine.setInventoryId(resultSet.getString("serial"));
               machine.setType(resultSet.getString("name"));
               machine.setFuterTO(formatter.format(resultSet.getDate("futerservice")));
               Date date = resultSet.getDate("lastservice");
               if(date !=null){
                machine.setLastTO(formatter.format(date));}else{machine.setLastTO("");}
                dfx.add(machine);
            }


    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dfx;
    }}
