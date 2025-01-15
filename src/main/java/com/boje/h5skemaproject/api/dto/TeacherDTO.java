package com.boje.h5skemaproject.api.dto;

import java.util.List;

public class TeacherDTO {
    private int teacher_id;
    private String firstName;
    private String lastName;


    public int getTeacher_id() {
        return teacher_id;
    }

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
}