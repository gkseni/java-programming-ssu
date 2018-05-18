package com.epam.ksenia_guseva.java.lesson2.task5.models;

public class Car {

    private String name;
    private String type;
    private String color;
    private double fuelConsumption;
    private double cost;

    public Car(String name, String type, String color, double fuelConsumption, double cost) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
