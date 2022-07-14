package com.example.practic2.DAO;

import com.example.practic2.entity.Machine;
import com.example.practic2.entity.Servicemachine;
import com.example.practic2.model.MachineListModel;
import com.example.practic2.model.ServiceMachineListModel;
import com.example.practic2.repository.ErrorListRepository;
import com.example.practic2.repository.MachineRepository;
import com.example.practic2.repository.PersonalRepository;
import com.example.practic2.repository.ServiceMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceMachineDAO {
    @Autowired
    ServiceMachineRepository serviceMachineRepository;
@Autowired
    ErrorListRepository errorListRepository;
@Autowired
    PersonalRepository personalRepository;
@Autowired
    MachineRepository machineRepository;

    @Transactional
    public void newMachineService(String status, Integer id, Integer errorId, LocalDate TOSS,LocalDate TOES) {
        Servicemachine servicemachine = new Servicemachine();
        servicemachine.setDos(TOSS);
        servicemachine.setDose(TOES);
        servicemachine.setStatus(status);
        servicemachine.setErrormessageid(errorListRepository.getErorrmessageById(errorId));
        servicemachine.setMachineid(machineRepository.findMachineBySerial(id));
        servicemachine.setEngineerid(personalRepository.findPersonalById(2));
        serviceMachineRepository.save(servicemachine);

    }
    @Transactional
    public List<ServiceMachineListModel> serviceMachineListModels(){
        List<Servicemachine> servicemachines = (List<Servicemachine>) serviceMachineRepository.findAll();
        List<ServiceMachineListModel> serviceMachineListModels = servicemachines.stream().map(servicemachine ->ServiceMachineListModel.builder()
                .firstName(servicemachine.getEngineerid().getFirstname())
                .secondName( servicemachine.getEngineerid().getSecondname())
                .thirdName(servicemachine.getEngineerid().getThirdname())
                .serial(servicemachine.getMachineid().getSerial())
                .id(servicemachine.getId())
                .status(servicemachine.getStatus())
                .dos(servicemachine.getDos())
                .dose(servicemachine.getDose())
                .build()).collect(Collectors.toList());
        return serviceMachineListModels;
    }

@Transactional
public void updateServicemachine(String status,Integer id,LocalDate TOES){
        Servicemachine servicemachine= serviceMachineRepository.findServicemachineById(id);
        if(!status.isEmpty()){
            servicemachine.setStatus(status);
        }
        if(TOES != null){
            servicemachine.setDose(TOES);
        }
        serviceMachineRepository.save(servicemachine);
    }}