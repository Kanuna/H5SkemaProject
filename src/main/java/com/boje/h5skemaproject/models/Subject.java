package com.boje.h5skemaproject.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subject_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Short hoursAmount;

    @Column()
    private Short hoursTP;

    @OneToMany(mappedBy = "subject")
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