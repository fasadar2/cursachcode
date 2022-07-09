package com.example.practic2.repository;

import com.example.practic2.entity.Erorrmessage;
import com.example.practic2.entity.Machine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorListRepository extends CrudRepository<Erorrmessage,Integer> {
    Erorrmessage getErorrmessageById(Integer id);
}
