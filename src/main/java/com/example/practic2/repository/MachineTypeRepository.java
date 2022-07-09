package com.example.practic2.repository;

import com.example.practic2.entity.Machine;
import com.example.practic2.entity.Machinetype;
import org.springframework.data.repository.CrudRepository;

public interface MachineTypeRepository extends CrudRepository<Machinetype,Integer> {
    Machinetype findMachinetypeByName(String name);
}
