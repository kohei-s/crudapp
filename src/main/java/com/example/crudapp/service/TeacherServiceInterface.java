package com.example.crudapp.service;

import com.example.crudapp.entity.Teacher;

import java.util.List;

public interface TeacherServiceInterface {

    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher save(Teacher teacher);
    void deleteById(int id);

}
