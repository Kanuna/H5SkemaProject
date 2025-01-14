package com.boje.h5skemaproject.api.dto;

import com.boje.h5skemaproject.models.Day;
import com.boje.h5skemaproject.models.Subject;
import com.boje.h5skemaproject.models.Teacher;

import java.time.LocalDate;

public class DayDTO {
    private int day_id;
    private LocalDate date;
    private Day.DayOfWeek day_of_week;
    private Subject subject;
    private Teacher teacher;


    public enum DayOfWeek {
        Mandag,
        Tirsdag,
        Onsdag,
        Torsdag,
        Fredag
    }


    public int getDay_id() {
        return day_id;
    }

    public LocalDate getLocalDate(){
        return date;
    }
    public void setLocalDate(LocalDate date){
        if(date != null){
            this.date = date;
        }
    }

    public Day.DayOfWeek getDayOfWeek(){
        return day_of_week;
    }
    public void setDayOfWeek(Day.DayOfWeek day_of_week){
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
