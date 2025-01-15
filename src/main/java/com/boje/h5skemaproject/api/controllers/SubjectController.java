package com.boje.h5skemaproject.api.controllers;

import com.boje.h5skemaproject.api.dto.SubjectDTO;
import com.boje.h5skemaproject.api.serviceimp.SubjectServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectServiceImp subjectServicImp;

    public SubjectController(SubjectServiceImp subjectServicImp) {
        this.subjectServicImp = subjectServicImp;
    }

    @GetMapping("/create")
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        return subjectServicImp.createSubject(subjectDTO);
    }

    @GetMapping("/{id}")
    public SubjectDTO getSubject(@PathVariable int id) {
        return subjectServicImp.getSubjectById(id);
    }

    @GetMapping("/all")
    public List<SubjectDTO> getAllSubjects() {
        return subjectServicImp.getAllSubjects();
    }

    @GetMapping("/update")
    public SubjectDTO updateSubject(SubjectDTO subjectDTO) {
        return subjectServicImp.updateSubject(subjectDTO);
    }

    @GetMapping("/delete/{id}")
    public void deleteSubject(@PathVariable int id) {
        subjectServicImp.deleteSubject(id);
    }
}