package com.boje.h5skemaproject.api.mapper;
import com.boje.h5skemaproject.api.dto.*;
import com.boje.h5skemaproject.models.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    TeacherDTO toTeacherDTO(Teacher teacher);
    Teacher toTeacher(TeacherDTO teacherDTO);

    SubjectDTO toSubjectDTO(Subject subject);
    Subject toSubject(SubjectDTO subjectDTO);

    DayDTO toDayDTO(Day day);
    Day toDay(DayDTO dayDTO);
}
