package com.example.practic2.DAO;

import com.example.practic2.entity.Machine;
import com.example.practic2.model.MachineListModel;
import com.example.practic2.repository.MachineRepository;
import com.example.practic2.repository.MachineTypeRepository;
import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MachineDAO {
    @Autowired
    MachineRepository machineRepository;
    @Autowired
    MachineTypeRepository machineTypeRepository;

    @Transactional
    public List<MachineListModel> setMachineRepository(){
        List<Machine> machineList = (List<Machine>) machineRepository.findAll();
        List<MachineListModel> machineListModels = machineList.stream().map(machine -> new MachineListModel(machine.getTypeid().getName(),
                machine.getRecommendation(),
                machine.getLastservice(),
                machine.getFuterservice(),
                machine.getToe(),
                machine.getEtoe(),
                machine.getStatus(),
                machine.getSerial())).collect(Collectors.toList());
    return machineListModels;
}
@Transactional
    public void SetStatusMachine(Integer serial,String status){
        Machine machine = machineRepository.findMachineBySerial(serial);
        machine.setStatus(status);
        machineRepository.save(machine);
}
@Transactional
    public void SetRecomendationMachine(Integer serial, String recomendation){
        Machine machine = machineRepository.findMachineBySerial(serial);
        machine.setRecommendation(recomendation);
        machineRepository.save(machine);
}
@Transactional
    public void SetLastTo(Integer serial, LocalDate date){
        Machine machine = machineRepository.findMachineBySerial(serial);
        machine.setLastservice(date);
        machineRepository.save(machine);
}
@Transactional
    public void NewMachine(Integer serial,String type,String recomendation, LocalDate DSE,LocalDate DEE,LocalDate dateNTO){
        Machine machine = new Machine();
        machine.setSerial(serial);
        machine.setRecommendation(recomendation);
        machine.setToe(DSE);
        machine.setTypeid(machineTypeRepository.findMachinetypeByName(type));
        machine.setEtoe(DEE);
        machine.setFuterservice(dateNTO);
        machineRepository.save(machine);

}
}

