package com.example.practic2.repository;

import com.example.practic2.entity.Servicemachine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceMachineRepository extends CrudRepository<Servicemachine,Integer>
{
    Servicemachine findServicemachineById(Integer id);
}
