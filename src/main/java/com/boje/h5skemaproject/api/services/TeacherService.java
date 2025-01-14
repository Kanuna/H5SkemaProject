package com.boje.h5skemaproject.api.services;
import com.boje.h5skemaproject.api.dto.TeacherDTO;
import java.util.List;

public interface TeacherService {
    TeacherDTO createTeacher(TeacherDTO teacherDTO);
    TeacherDTO getTeacherById(int id);
    List<TeacherDTO> getAllTeachers();
    TeacherDTO updateTeacher(TeacherDTO teacherDTO);
    void deleteTeacher(int id);
}
