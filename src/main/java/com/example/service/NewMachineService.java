package com.example.service;


import jakarta.inject.Singleton;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@Singleton
public class NewMachineService {
    private int request = 0;
    public int GetId(String machine, String id, String recomendation, String dateNTO, String dateDSE, String dateDEE ){
        CheckID(id);
        if(request == 2){return request;}
        CheckIDExist(CheckID(id));
        if(request == 3){return request;}
        FindType(machine);
        if(request == 4){return request;}
        request =  Insert( FindType(machine), CheckID(id),  recomendation,  dateNTO,  dateDSE,  dateDEE);
        return request;
    }





private int FindType(String machine){
        int answer = 0;
        int i =0 ;
    try{
        Connection connn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

        String sqls = "Select * from medicalservice.machinetype  ";
        PreparedStatement pss = connn.prepareStatement(sqls);
        ResultSet rs = pss.executeQuery();

        while (rs.next()){
            if((Objects.equals(machine, rs.getString("name")))){answer = rs.getInt("id"); i = 1;}
        }
        if (i == 0 ){request = 4; }

    }catch (SQLException throwables) {throwables.printStackTrace();}
        return answer;

}

    private int CheckID(String id){
        int answer = 0;
        try{answer = Integer.parseInt(id);}catch(NumberFormatException nfe){request = 2;}

        return answer;
    }
    private int CheckIDExist(int id){
        int answer = 0;
        int i = 0;
        try{
            Connection connn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

            String sqls = "Select * from medicalservice.machine  ";
            PreparedStatement pss = connn.prepareStatement(sqls);
            ResultSet rs = pss.executeQuery();

            while (rs.next()){
                if(id == rs.getInt("serial")){i = 1;}
            }
            if (i == 1 ){request = 3; }

    }catch (SQLException throwables) {throwables.printStackTrace();}
        return answer;
}

private int Insert(int machine, int id, String recomendation, String dateNTO, String dateDSE, String dateDEE)  {
        int answer =0;

    try{
       LocalDate datento = LocalDate.parse(dateNTO);
        LocalDate datedse = LocalDate.parse(dateDSE);
        LocalDate datedee = LocalDate.parse(dateDEE);

        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

        String sql = "insert into medicalservice.machine values ( default,?,?,null,?,?,?,null,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1,machine);
        ps.setString(2,recomendation);
        ps.setDate(3,  java.sql.Date.valueOf(datento));
        ps.setDate(4,  java.sql.Date.valueOf(datedse));
        ps.setDate(5,  java.sql.Date.valueOf(datedee));
        ps.setInt(6,id);
        ps.executeUpdate();



        answer = 1;
    }catch (SQLException throwables) {throwables.printStackTrace();}
        return answer;
}
}
// request = 1 OK, request = 2 check id input, request = 3 this id already exist, request = 4 invalid type