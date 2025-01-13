package com.boje.h5skemaproject.api.dto;

import com.boje.h5skemaproject.models.Day;

import java.util.List;

public class SubjectDTO {
    private String name;
    private short hoursAmount;
    private short hoursTP;
    private List<Day> days;

    public String getName(){
        return name;
    }
    public void setName(String name){
        if(!name.isEmpty()){
            this.name = name;
        }
    }

    public Short getHoursAmount(){
        return hoursAmount;
    }
    public void setHoursAmount(Short hoursAmount){
        this.hoursAmount = hoursAmount;
    }

    public Short getHoursTP(){
        return hoursTP;
    }
    public void setHoursTP(Short hoursTP){
        this.hoursTP = hoursTP;
    }

    public List<Day> getDays(){
        return days;
    }
    public void setDays(List<Day> days){
        this.days = days;
    }
}