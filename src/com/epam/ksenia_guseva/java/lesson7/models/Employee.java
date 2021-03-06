package com.epam.ksenia_guseva.java.lesson7.models;

public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private String position;

    public Employee(String name, Integer age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Employee() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() { return  age;}

    public String getPosition() {
        return position;
    }

}
