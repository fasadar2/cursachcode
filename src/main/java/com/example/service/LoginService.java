package com.example.service;

import jakarta.inject.Singleton;
import java.sql.*;
import java.util.Objects;

@Singleton
public class LoginService {
    private int PersonalId= 0;
    public int getloginpass(String log , String password) {
        int greeting = 0 ;
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

            String sql = "Select * from medicalservice.datelog  ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                if((Objects.equals(log, rs.getString("login")))
                        &((Objects.equals(password, rs.getString("password"))))){
                    PersonalId = rs.getInt("idpersonal");

                }
            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(Objects.equals(log.substring(0,3),"eng")){greeting = 1;}


        if(Objects.equals(log.substring(0,3),"doc")){greeting = 2;}
        return greeting;
    }
    public int getPersonalId(){return PersonalId;}
}
//if greeting = 0 login and password not found if greeting = 1 successful login