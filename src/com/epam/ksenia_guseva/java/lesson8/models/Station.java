package com.epam.ksenia_guseva.java.lesson8.models;

import java.util.ArrayList;
import java.util.List;

public class Station {

    private List<Car> cars = null;

    public Station() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

}
