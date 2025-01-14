package com.boje.h5skemaproject.api.controllers;

import com.boje.h5skemaproject.api.dto.TeacherDTO;
import org.springframework.web.bind.annotation.*;
import com.boje.h5skemaproject.api.serviceimp.TeacherServiceImp;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherServiceImp teacherServiceImp;

    public TeacherController(TeacherServiceImp teacherServiceImp) {
        this.teacherServiceImp = teacherServiceImp;
    }

    @GetMapping("/create")

    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherServiceImp.createTeacher(teacherDTO);
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacher(@PathVariable int id){
        return teacherServiceImp.getTeacherById(id);
    }

    @GetMapping("/all")
    public List<TeacherDTO> getAllTeacher(){
        return teacherServiceImp.getAllTeachers();
    }

    @GetMapping("/update")
    public TeacherDTO updateTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherServiceImp.updateTeacher(teacherDTO);
    }

    @GetMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable int id){
        teacherServiceImp.deleteTeacher(id);
    }
}