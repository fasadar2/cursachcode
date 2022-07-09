package com.example.practic2.repository;

import com.example.practic2.entity.Personal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends CrudRepository<Personal,Integer> {
    Personal findPersonalById(Integer id);
}
