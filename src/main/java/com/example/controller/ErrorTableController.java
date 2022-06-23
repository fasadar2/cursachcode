package com.example.controller;

import com.example.model.ErrorTableModel;

import com.example.model.MachineListModel;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Controller("/get")
public class ErrorTableController {
    @Get("/errortable")
    public ArrayList<ErrorTableModel> greet() {
        ArrayList<ErrorTableModel> dfx = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
            String sql = "Select * From medicalservice.erorrmessage join medicalservice.machine as mac on mac.id = medicalservice.erorrmessage.machineid join medicalservice.cabinet as cab on cab.id = medicalservice.erorrmessage.cabinetid join medicalservice.personal as pers on pers.id = medicalservice.erorrmessage.iddoctor";
            PreparedStatement ps = conn.prepareStatement(sql);
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ErrorTableModel error = new ErrorTableModel();
                error.setCabinetNumber(resultSet.getString("name"));
                error.setDate(formatter.format(resultSet.getDate("date")));
                error.setMachinenumber(resultSet.getString("serial"));
                error.setMessage(resultSet.getString("message"));
                error.setNameDoctor(resultSet.getString("firstname")+" "+resultSet.getString("secondname")+" "+resultSet.getString("thirdname"));
                dfx.add(error);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        return dfx;
    }
}
