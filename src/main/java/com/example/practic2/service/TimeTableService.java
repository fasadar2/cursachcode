package com.example.practic2.service;

import com.example.practic2.DAO.TimeTableDAO;
import com.example.practic2.model.TimeTableListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService {
    @Autowired
    TimeTableDAO timeTableDAO;
    public List<TimeTableListModel> getTimeTableModel(){
        return timeTableDAO.getTimeTableList();
    }
}
