package com.boje.h5skemaproject.api.services;
import com.boje.h5skemaproject.api.dto.SubjectDTO;
import java.util.List;

public interface SubjectService {
    SubjectDTO createSubject(SubjectDTO subject);
    SubjectDTO getSubjectById(int id);
    List<SubjectDTO> getAllSubjects();
    SubjectDTO updateSubject(SubjectDTO subject);
    void deleteSubject(int id);
}
