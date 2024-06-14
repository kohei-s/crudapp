package com.example.crudapp.service;

import com.example.crudapp.dao.TeacherRepository;
import com.example.crudapp.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherServiceInterface {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository tRepository) {
        teacherRepository = tRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Teacher findById(int id) {
        Optional<Teacher> result = teacherRepository.findById(id);
        Teacher teacher = null;

        if (result.isPresent()) {
            teacher = result.get();
        } else {
            throw new RuntimeException("Couldn't find teacher with id: " + id);
        }

        return teacher;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }
}
