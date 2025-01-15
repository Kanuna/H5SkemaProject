package com.boje.h5skemaproject.api.serviceimp;

import com.boje.h5skemaproject.api.ResourceNotFoundException.ResourceNotFoundException;
import com.boje.h5skemaproject.api.dto.SubjectDTO;
import com.boje.h5skemaproject.api.mapper.ModelMapper;
import com.boje.h5skemaproject.api.services.SubjectService;
import com.boje.h5skemaproject.models.Subject;
import com.boje.h5skemaproject.repositories.SubjectRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImp implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public SubjectServiceImp(SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        try{
            Subject subject = modelMapper.toSubject(subjectDTO);
            Subject savedSubject = subjectRepository.save(subject);
            return modelMapper.toSubjectDTO(savedSubject);
        }
        catch(Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }


    @Override
    public SubjectDTO getSubjectById(int id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
        return modelMapper.toSubjectDTO(subject);
    }


    @Override
    public List<SubjectDTO> getAllSubjects() {
        try{
            List<Subject> subjects = subjectRepository.findAll();
            return subjects.stream()
                    .map(modelMapper::toSubjectDTO)
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }


    @Override
    public SubjectDTO updateSubject(SubjectDTO subjectDTO) {
        Subject existingSubject = subjectRepository.findById(subjectDTO.getSubject_id())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + subjectDTO.getSubject_id()));
        Subject updatedSubject = subjectRepository.save(existingSubject);
        return modelMapper.toSubjectDTO(updatedSubject);
    }

    @Override
    public void deleteSubject(int id) {
        try {
            subjectRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Subject not found with id: " + id);
        }
    }
}