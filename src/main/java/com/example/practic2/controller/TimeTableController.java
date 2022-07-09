package com.example.practic2.controller;

import com.example.practic2.model.TimeTableListModel;
import com.example.practic2.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeTableController {
    @Autowired
    TimeTableService timeTableService;

    @GetMapping(path = "/getTimeTableList")
    public List<TimeTableListModel> GetTimeTableList(){
        return timeTableService.getTimeTableModel();
    }
}
