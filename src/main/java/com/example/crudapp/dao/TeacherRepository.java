package com.example.crudapp.dao;

import com.example.crudapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    public List<Teacher> findAllByOrderByLastNameAsc();


}
