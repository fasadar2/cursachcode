package com.example.practic2.repository;

import com.example.practic2.entity.Servicemachine;
import com.example.practic2.entity.Timetable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends CrudRepository<Timetable,Integer> {
}
