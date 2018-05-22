package com.epam.ksenia_guseva.java.lesson8.task5.models;

/**
 * Created by gkseni on 20.05.2018.
 */
public class Car {
    private String name;
    private String type;
    private String color;
    private Double fuelConsumption;
    private Double cost;

    public Car(String name, String type, String color, Double fuelConsumption, Double cost) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.cost = cost;
    }
}
