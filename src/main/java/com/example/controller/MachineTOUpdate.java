package com.example.controller;

import com.example.entity.MachineTO;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

@Controller("/machine")
public class MachineTOUpdate {
    @Post(value = "/to", consumes = MediaType.APPLICATION_JSON)
    public int login(@Body MachineTO machine) {
        int request = 0;
        try{
            int answer = 0;

            try{answer = Integer.parseInt(machine.getSerial());}catch(NumberFormatException nfe){request = 2;}
            LocalDate lastto = LocalDate.parse(machine.getLastTO());
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
            String sql = "Update medicalservice.machine  set lastservice = ? where serial = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1,java.sql.Date.valueOf(lastto));
            ps.setInt(2,answer);
             ps.executeUpdate();
            request = 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return request;

    }
}
