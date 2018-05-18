package com.epam.ksenia_guseva.java.lesson3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    public String firstName;
    public String secondName;
    public String studyCourse;
    public Date startDate;

    public List<Course> courses = new ArrayList<>();

    public Student(String firstName, String secondName, String studyCourse, Date startDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.studyCourse = studyCourse;
        this.startDate = startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getStudyCourse() {
        return studyCourse;
    }

    public void setStudyCourse(String studyCourse) {
        this.studyCourse = studyCourse;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

}
