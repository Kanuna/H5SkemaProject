package com.boje.h5skemaproject.repositories;

import com.boje.h5skemaproject.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
