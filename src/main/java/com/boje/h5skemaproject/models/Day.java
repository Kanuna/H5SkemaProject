package com.boje.h5skemaproject.models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int day_id;

    @Column
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column
    private DayOfWeek day_of_week;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @ManyToOne()
    @JoinColumn(name = "teacher_id", nullable = false)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Teacher teacher;


    public enum DayOfWeek {
        Mandag,
        Tirsdag,
        Onsdag,
        Torsdag,
        Fredag
    }


    public LocalDate getLocalDate(){
        return date;
    }
    public void setLocalDate(LocalDate date){
        if(date != null){
            this.date = date;
        }
    }

    public DayOfWeek getDayOfWeek(){
        return day_of_week;
    }
    public void setDayOfWeek(DayOfWeek day_of_week){
        this.day_of_week = day_of_week;
    }

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher(){
        return teacher;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
}
