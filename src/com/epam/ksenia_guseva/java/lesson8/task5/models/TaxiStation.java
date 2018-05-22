package com.epam.ksenia_guseva.java.lesson8.task5.models;

import java.util.List;

public class TaxiStation {
    public List<Car> taxis;

    public TaxiStation() {
        this.taxis = taxis;
    }

    public List<Car> getTaxis() {
        return taxis;
    }

    public void addCar(Car car) {
        taxis.add(car);
    }
}
