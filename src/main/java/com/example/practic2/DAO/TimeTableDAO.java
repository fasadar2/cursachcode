package com.example.practic2.DAO;

import com.example.practic2.entity.Timetable;
import com.example.practic2.model.TimeTableListModel;
import com.example.practic2.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeTableDAO {
    @Autowired
    TimeTableRepository timeTableRepository;

    @Transactional
    public List<TimeTableListModel> getTimeTableList(){
        List<Timetable> timetables = (List<Timetable>) timeTableRepository.findAll();
        List<TimeTableListModel> timeTableListModels = timetables.stream().map(timetable -> new TimeTableListModel(
                timetable.getIdcabinet().getName(),timetable.getIdpersonal().getFirstname(),timetable.getIdpersonal().getSecondname(),
                timetable.getIdpersonal().getThirdname(),timetable.getDate(),timetable.getMachineid().getTypeid().getName()
        )).collect(Collectors.toList());
        return timeTableListModels;
    }
}
