package com.epam.ksenia_guseva.java.lesson8.models;

public class Car {

    private String type;
    private String color;
    private Double fuelConsumption;
    private Double cost;

    public Car(String type, String color,
               Double fuelConsumption, Double cost) {
        this.type = type;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.cost = cost;
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

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", cost=" + cost +
                '}';
    }
}
