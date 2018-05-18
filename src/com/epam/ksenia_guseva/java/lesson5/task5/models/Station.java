package com.epam.ksenia_guseva.java.lesson5.task5.models;

import com.epam.ksenia_guseva.java.lesson5.task5.interfaces.TaxiStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Station implements TaxiStation {

    private List<Car> taxis = null;

    public Station() {
        this.taxis = new ArrayList<>();
    }

    public List<Car> getTaxis() {
        return taxis;
    }

    public void add(Car car) {
        this.taxis.add(car);
    }

    public void sort() {
        this.taxis.sort((firstTaxi, secondTaxi) -> {
            Double fuelConsumption1 = firstTaxi.getFuelConsumption();
            Double fuelConsumption2 = secondTaxi.getFuelConsumption();
            return fuelConsumption1.compareTo(fuelConsumption2);
        });
    }

    public double getTaxisCost() {
        return this.taxis.stream()
                .map(Car::getCost)
                .reduce(0.0, (a, b)
                        -> a + b);
    }

    public List<Car> findCarByColor(String color) {
        return this.taxis.stream().filter(car -> {
            String carColor = car.getColor();
            return Objects.equals(carColor, color);
        }).collect(Collectors.toList());
    }


}
