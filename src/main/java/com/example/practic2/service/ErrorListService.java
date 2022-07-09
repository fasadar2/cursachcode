package com.example.practic2.service;

import com.example.practic2.DAO.ErrorListDAO;
import com.example.practic2.model.ErrorListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorListService {
    @Autowired
    ErrorListDAO errorListDAO;

    public List<ErrorListModel> GetErrorList(){return errorListDAO.getErrorList();}
}
