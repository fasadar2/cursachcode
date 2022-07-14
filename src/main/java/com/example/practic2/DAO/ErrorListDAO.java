package com.example.practic2.DAO;

import com.example.practic2.entity.Erorrmessage;
import com.example.practic2.model.ErrorListModel;
import com.example.practic2.repository.ErrorListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ErrorListDAO {
    @Autowired
    ErrorListRepository errorListRepository;
    @Transactional
    public List<ErrorListModel> getErrorList(){
        List<Erorrmessage> erorrmessageList = (List<Erorrmessage>) errorListRepository.findAll();
        List<ErrorListModel> errorListModels = erorrmessageList.stream().map(erorrmessage ->ErrorListModel.builder()
                .firstname(erorrmessage.getIddoctor().getFirstname())
                .secondname(erorrmessage.getIddoctor().getSecondname())
                .thirdname(erorrmessage.getIddoctor().getThirdname())
                .id(erorrmessage.getId())
                .cabinetnumber(erorrmessage.getCabinetid().getName())
                .date(erorrmessage.getDate())
                .serial(erorrmessage.getMachineid().getSerial())
                .build()).collect(Collectors.toList());
        return errorListModels;
    }
}
