package com.example.service;
import com.example.service.LoginService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

@Singleton
public class ServiceMachineService {
    @Inject
    LoginService login;
    private int request = 0;
    private int Serial;
    private int ErrorID = -1;
    private int emptyDoSE = 1;
    private int combine = 0;
    private LocalDate dose;
    public int GetId(String serial,String errormessageid,String status,String DoS,String DoSE){
        Serial = CheckID(serial);
        if (request == 2){return request;}
        if(request == 3){return request;}
        if(!errormessageid.isEmpty()){ErrorID = CheckErrorID(errormessageid);}
        if (request == 4){return request;}
        if(request == 5){return request;}
        if(!DoSE.isEmpty()){emptyDoSE = 0; dose = LocalDate.parse(DoSE);}
        request = Insert(Serial,ErrorID,login.getPersonalId(),status,DoS,DoSE);
        return request;
    }
    public int GetId2(String id,String status,String DoSE){
        Serial = CheckID2(id);
        if (request == 2){return request;}
        if(request == 3){return request;}
        if(status.isEmpty() & DoSE.isEmpty()){request = 4; return request;}

        if(!status.isEmpty() & !DoSE.isEmpty()){combine = 1;request = Insert2(Serial,status,DoSE);}
        if(!status.isEmpty() & DoSE.isEmpty()){combine = 2;request = Insert2(Serial,status,DoSE);}
        if(status.isEmpty() & !DoSE.isEmpty()){combine = 3;request = Insert2(Serial,status,DoSE);}
        return request;
    }

    private int Insert(int id,int errormessageid,int personalid,String status,String DoS,String DoSE ){
        int answer = 0;
        LocalDate dos = LocalDate.parse(DoS);

        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
            if((ErrorID != -1)&(emptyDoSE !=1)) {
                String sql = "insert into medicalservice.servicemachine values (default,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, personalid);
                ps.setInt(2, id);
                ps.setInt(3, errormessageid);
                ps.setString(4, status);
                ps.setDate(5, java.sql.Date.valueOf(dos));
                ps.setDate(6, java.sql.Date.valueOf(dose));
                ps.executeUpdate();
                answer = 1;
            }
            if((ErrorID == -1)&(emptyDoSE ==0)) {
                String sql = "insert into medicalservice.servicemachine values (default,?,?,null,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, personalid);
                ps.setInt(2, id);
                ps.setString(3, status);
                ps.setDate(4, java.sql.Date.valueOf(dos));
                ps.setDate(5, java.sql.Date.valueOf(dose));
                ps.executeUpdate();
                answer = 1;
            }

            if((ErrorID != -1)&(emptyDoSE == 1)) {
                String sql = "insert into medicalservice.servicemachine values (default,?,?,?,?,?,null)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, personalid);
                ps.setInt(2, id);
                ps.setString(3, status);
                ps.setInt(4, errormessageid);
                ps.setDate(5, java.sql.Date.valueOf(dos));
                ps.executeUpdate();
                answer = 1;
            }

            if((ErrorID == -1)&(emptyDoSE ==1)) {
                String sql = "insert into medicalservice.servicemachine values (default,?,?,null,?,?,null)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, personalid);
                ps.setInt(2, id);
                ps.setString(3, status);
                ps.setDate(4, java.sql.Date.valueOf(dos));
                ps.executeUpdate();
                answer = 1;
            }
        }catch (SQLException throwables) {throwables.printStackTrace();}
  return answer;
    }

    private int Insert2(int id,String status,String DoSE ){
        int answer = 0;


        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
            if(combine ==1) {
                dose = LocalDate.parse(DoSE);
                String sql = "UPDATE medicalservice.servicemachine set status = ?,dose = ? where id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, status);
                ps.setDate(2, java.sql.Date.valueOf(dose));
                ps.setInt(3, id);
                ps.executeUpdate();
                answer = 1;
            }
            if(combine == 2) {
                String sql = "UPDATE medicalservice.servicemachine set status = ? where id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, status);
                ps.setInt(2, id);
                ps.executeUpdate();
                answer = 1;
            }

            if(combine == 3) {
                String sql = "UPDATE medicalservice.servicemachine set dose = ? where id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setDate(1, java.sql.Date.valueOf(dose));
                ps.setInt(2, id);
                ps.executeUpdate();
                answer = 1;
            }


        }catch (SQLException throwables) {throwables.printStackTrace();}
        return answer;
    }



    private int CheckErrorID(String errorID){
        int answer=0;
        try{answer = Integer.parseInt(errorID);}catch(NumberFormatException nfe){request = 4;}


        int i =0 ;
        try{
            Connection connn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

            String sqls = "Select * from medicalservice.erorrmessage  ";
            PreparedStatement pss = connn.prepareStatement(sqls);
            ResultSet rs = pss.executeQuery();

            while (rs.next()){
                if(answer == rs.getInt("id")){ i = 1;}
            }
            if (i == 0 ){request = 5; }

        }catch (SQLException throwables) {throwables.printStackTrace();}



        return answer;
    }

    private int CheckID(String serial){
        int answer = 0;
        int id = 0;
        try{answer = Integer.parseInt(serial);id = answer;}catch(NumberFormatException nfe){request = 2;}


            int i =0 ;
            try{
                Connection connn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

                String sqls = "Select * from medicalservice.machine  ";
                PreparedStatement pss = connn.prepareStatement(sqls);
                ResultSet rs = pss.executeQuery();

                while (rs.next()){
                    if(id == rs.getInt("serial")){answer = rs.getInt("id"); i = 1;}
                }
                if (i == 0 ){request = 3; }

            }catch (SQLException throwables) {throwables.printStackTrace();}



        return answer;
    }

    private int CheckID2(String serial){
        int answer = 0;
        int id = 0;
        try{answer = Integer.parseInt(serial);id = answer;}catch(NumberFormatException nfe){request = 2;}


        int i =0 ;
        try{
            Connection connn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");

            String sqls = "Select * from medicalservice.servicemachine  ";
            PreparedStatement pss = connn.prepareStatement(sqls);
            ResultSet rs = pss.executeQuery();

            while (rs.next()){
                if(id == rs.getInt("id")){answer = rs.getInt("id"); i = 1;}
            }
            if (i == 0 ){request = 3; }

        }catch (SQLException throwables) {throwables.printStackTrace();}



        return answer;
    }
}
// request = 1 OK, request = 2 check id input, request = 3 invalid serial,request = 4 check errorid input, request = 5 invalid errorid

//private int CheckID(String serial){
//    int answer = 0;
//    return answer;
//}