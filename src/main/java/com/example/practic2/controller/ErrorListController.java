package com.example.practic2.controller;

import com.example.practic2.model.ErrorListModel;
import com.example.practic2.service.ErrorListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ErrorListController {
    @Autowired
    ErrorListService errorListService;
   @GetMapping(value = "/getErrorList")
    public List<ErrorListModel> getErrorList(){
       return errorListService.getErrorList();
   }
}
