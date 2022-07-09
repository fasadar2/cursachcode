package com.example.practic2.repository;

import com.example.practic2.entity.Datelog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends CrudRepository<Datelog,Integer> {
    List<Datelog> findDatelogByLoginAndPassword(String login,String password);
}
