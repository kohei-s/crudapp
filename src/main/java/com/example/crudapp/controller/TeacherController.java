package com.example.crudapp.controller;

import com.example.crudapp.entity.Teacher;
import com.example.crudapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService myTeacherService) {
        teacherService = myTeacherService;
    }

    @GetMapping("/get")
    public String getTeachers(Model model) {
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);

        return "teachers/get-teachers";
    }

    @GetMapping("addTeacher")
    public String addTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "teachers/teacher-form";
    }

    @GetMapping("/updateTeacher")
    public String updateTeacher(@RequestParam("teacherId") int id, Model model) {
        Teacher teacher = teacherService.findById(id);
        model.addAttribute("teacher", teacher);

        return "teachers/teacher-form";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.save(teacher);

        return "redirect:/teachers/get";
    }

    @GetMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("teacherId") int id) {
        teacherService.deleteById(id);

        return "redirect:/teachers/get";
    }
}
