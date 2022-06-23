package com.example.service;

import jakarta.inject.Singleton;

import java.sql.*;
import java.util.Objects;

@Singleton
public class MachineIDService {
    private int request = 0;
    private int idm = 0;
    private int i = 0;
    public int GetId(String id, int is){

        try {
            idm = Integer.parseInt(id);

            try{
                Connection connn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

                String sqls = "Select * from medicalservice.machine  ";
                PreparedStatement pss = connn.prepareStatement(sqls);
                ResultSet rs = pss.executeQuery();

                while (rs.next()){
                    if(idm == rs.getInt("serial")){i = 1;}
                }
                if (i == 0 ){request = 3; return request;}
        try {




            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

            String sql = "UPDATE medicalservice.machine set status = ? where serial = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            if(is == 1){
                ps.setString(1, "Исправно");
            }
            if(is == 2){
                ps.setString(1,"Неисправно");
            }
            ps.setInt(2,idm);
            ps.executeUpdate();
            request = 1;


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            }catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }catch(NumberFormatException nfe){request = 2;}


        return request;
    }
}
//request = 1 OK request = 2 bad number request = 0 error request = 3 invalid id