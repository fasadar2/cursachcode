package com.example.service;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import com.example.model.ServiceMachineModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CreateExelService {
    @Inject
    private  LoginService login;
        public  void CreateExel() throws ParseException {

            // создание самого excel файла в памяти
            HSSFWorkbook workbook = new HSSFWorkbook();
            // создание листа с названием "Просто лист"
            HSSFSheet sheet = workbook.createSheet("Просто лист");

            // заполняем список какими-то данными
            List<ServiceMachineModel> dataList = fillData();


            // счетчик для строк
            int rowNum = 0;

            // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
            Row row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue("ИД");
            row.createCell(1).setCellValue("Инвентарный номер оборудования");
            row.createCell(2).setCellValue("Сообщение о ошибке");
            row.createCell(3).setCellValue("Статус");
            row.createCell(4).setCellValue("Дата поступления в сервис");
            row.createCell(5).setCellValue("Дата выхода из сервиса");
            // заполняем лист данными
            for (ServiceMachineModel serviceMachineModel : dataList) {
                createSheetHeader(sheet, ++rowNum, serviceMachineModel);
            }

            // записываем созданный в памяти Excel документ в файл
            try (FileOutputStream out = new FileOutputStream(new File(".\\ServiceReport.xls"))) {
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Excel файл успешно создан!");
        }

        // заполнение строки (rowNum) определенного листа (sheet)
        // данными  из dataModel созданного в памяти Excel файла
        private static void createSheetHeader(HSSFSheet sheet, int rowNum, ServiceMachineModel dataModel) {
            Row row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(dataModel.getId());
            row.createCell(1).setCellValue(dataModel.getSerial());
            row.createCell(2).setCellValue(dataModel.getMessage());
            row.createCell(3).setCellValue(dataModel.getStatus());
            row.createCell(4).setCellValue(dataModel.getDos());
            row.createCell(5).setCellValue(dataModel.getDose());

        }

        // заполняем список рандомными данными
        // в реальных приложениях данные будут из БД или интернета
        private  List<ServiceMachineModel> fillData() {
            ArrayList<ServiceMachineModel> dfx = new ArrayList<>();

            try{
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medicalservice", "god", "jhy2b5sv89pthbn");
                String sql = "Select * From medicalservice.servicemachine join medicalservice.machine as mac on mac.id = servicemachine.machineid LEFT OUTER JOIN medicalservice.erorrmessage as error on error.id = servicemachine.errormessageid where engineerid = ? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                System.out.println(login.getPersonalId());
                ps.setInt(1,login.getPersonalId());
                Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    ServiceMachineModel service = new ServiceMachineModel();
                    service.setId(Integer.toString(resultSet.getInt("id")));
                    service.setMessage(resultSet.getString("message"));
                    service.setStatus(resultSet.getString("status"));
                    service.setSerial(resultSet.getString("serial"));
                    service.setDos(formatter.format(resultSet.getDate("dos")));
                    service.setDose(formatter.format(resultSet.getDate("dose")));
                    dfx.add(service);
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }




            return dfx;
        }
    }

