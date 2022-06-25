package com.example.service;

import jakarta.inject.Singleton;

import java.sql.*;
import java.time.LocalDate;
@Singleton
public class UpdateRecomendationService {
    private int idm;
    private int request = 0;
    public int Update(String serial,String recomendation){
        Getid(serial);if(request ==2){return request;}if(request ==3){return request;}
        Insert(idm,recomendation);
        return request;
    }
    private int Getid(String serial){
        try {
            idm = Integer.parseInt(serial);

            try{
                int i = 0;
                Connection connn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

                String sqls = "Select * from medicalservice.machine  ";
                PreparedStatement pss = connn.prepareStatement(sqls);
                ResultSet rs = pss.executeQuery();

                while (rs.next()){
                    if(idm == rs.getInt("serial")){i = 1;}
                }
                if (i == 0 ){request = 3; return request;}}catch (SQLException throwables) {
                throwables.printStackTrace();
            }}catch(NumberFormatException nfe){request = 2;}
        return request;
    }

    private int Insert(int id,String recomendation ){
        int answer = 0;


        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
                String sql = "UPDATE medicalservice.machine set recommendation = ? where serial = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, recomendation);
                ps.setInt(2, id);
                ps.executeUpdate();
                request = 1;


        }catch (SQLException throwables) {throwables.printStackTrace();}
        return request;
    }
}
//request = 1 OK request = 2 bad number request = 0 error request = 3 invalid id