package com.example.practic2.repository;

import com.example.practic2.entity.Machine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends CrudRepository<Machine,Integer> {
Machine findMachineBySerial(Integer serial);


}
