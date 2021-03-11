package com.chuhelan.domain;

import java.util.List;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 14:40
 **/

public class Student {
    private String name;
    private String gender;
    private Phone phone;
    private List<String> hobby;

    public Student() {
    }

    public Student(String name, String gender, Phone phone, List<String> hobby) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ", hobby=" + hobby +
                '}';
    }
}