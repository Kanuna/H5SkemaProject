package com.boje.h5skemaproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacher_id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "teacher")
    private List<Day> day;



    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if(!firstName.isEmpty()){
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if(!lastName.isEmpty()){
            this.lastName = lastName;
        }
    }

    public List<Day> getDay() {
        return day;
    }
    public void setDay(List<Day> day) {
        this.day = day;
    }

/*    public List<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }*/
}
