package com.boje.h5skemaproject.api.serviceimp;

import com.boje.h5skemaproject.api.ResourceNotFoundException.ResourceNotFoundException;
import com.boje.h5skemaproject.api.dto.TeacherDTO;
import com.boje.h5skemaproject.api.mapper.ModelMapper;
import com.boje.h5skemaproject.api.services.TeacherService;
import com.boje.h5skemaproject.models.Teacher;
import com.boje.h5skemaproject.repositories.TeacherRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImp implements TeacherService {
    private final TeacherRepository teacherRepository;
    private ModelMapper modelMapper;

    public TeacherServiceImp(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        try{
            Teacher teacher = modelMapper.toTeacher(teacherDTO);
            teacherRepository.save(teacher);
            return modelMapper.toTeacherDTO(teacher);
        }
        catch(Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    public TeacherDTO getTeacherById(int id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
        return modelMapper.toTeacherDTO(teacher);
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        try{
            List<Teacher> teachers = teacherRepository.findAll();
            return teachers.stream()
                    .map(modelMapper::toTeacherDTO)
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }

    }

    @Override
    public TeacherDTO updateTeacher(TeacherDTO teacherDTO) {
        Teacher existingTeacher = teacherRepository.findById(teacherDTO.getTeacher_id())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + teacherDTO.getTeacher_id()));
        Teacher updatedTeacher = teacherRepository.save(existingTeacher);
        return modelMapper.toTeacherDTO(updatedTeacher);
    }

    @Override
    public void deleteTeacher(int id) {
        try {
            teacherRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Teacher not found with id: " + id);
        }
    }
}