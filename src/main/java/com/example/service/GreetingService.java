package com.example.service;

import jakarta.inject.Singleton;
import java.sql.*;
@Singleton
public class GreetingService {
    public String getGreeting() {
        String greeting = "hello";
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

            String sql = "Select name from medicalservice.cabinet ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                greeting = rs.getString("name");


            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return greeting;
    }
}
