package com.example.controller;


import com.example.model.DoctorTableModel;
import com.example.service.LoginService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Controller("/doctor")
public class TimeTableController {
    @Inject
    private LoginService login;


    @Get(value="/timetable")
    public ArrayList<DoctorTableModel> timetable() {
        ArrayList<DoctorTableModel> dfx = new ArrayList<>();



            try{
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
                String sql = "select * from medicalservice.timetable join medicalservice.cabinet as cab on timetable.idcabinet = cab.id join medicalservice.machine as mac on timetable.machineid = mac.id join medicalservice.machinetype as type on mac.typeid = type.id where idpersonal = ? ORDER BY date DESC";
                PreparedStatement ps = conn.prepareStatement(sql);
                Format formatter = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
                ps.setInt(1,login.getPersonalId());
                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    DoctorTableModel doctorTableModel = new DoctorTableModel();
                    doctorTableModel.setCabinet(resultSet.getString("name"));
                    doctorTableModel.setMachinename(resultSet.getString(18));
                    doctorTableModel.setDate(formatter.format(resultSet.getTimestamp("date")));
                    dfx.add(doctorTableModel);
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        return dfx ;
    }

}
