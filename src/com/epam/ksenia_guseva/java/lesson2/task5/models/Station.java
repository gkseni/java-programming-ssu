package com.epam.ksenia_guseva.java.lesson2.task5.models;

import com.epam.ksenia_guseva.java.lesson2.task5.interfaces.TaxiStation;

import java.util.Arrays;

public class Station implements TaxiStation {

    private Car[] taxis;

    public Station(int n) {
        this.taxis = new Car[n];
    }

    public Car[] getTaxis() {
        return taxis;
    }

    public void add(int index, Car car) {
        this.taxis[index] = car;
    }

    public double getTaxisCost() {
        double carCost = 0;
        for (Car car: this.taxis) {
            System.out.println(car.getCost());
        }
        return carCost;
    }

    public Car[] findCarByCost(double minCost, double maxCost) {
        int n = 0;
        for (Car car : taxis) {
            double carCost = car.getCost();
            if (carCost >= minCost && carCost <= maxCost) {
                n++;
            }
        }

        int i = 0;
        Car[] result = new Car[n];
        for (Car car : this.taxis) {
            double carCost = car.getCost();
            if (carCost >= minCost && carCost <= maxCost) {
                result[++i] = car;
            }
        }

        return result;
    }

    public void sort() {
        Arrays.sort(this.taxis, (car1, car2) -> {
            Double fuelConsumption1 = car1.getFuelConsumption();
            Double fuelConsumption2 = car2.getFuelConsumption();
            return fuelConsumption1.compareTo(fuelConsumption2);
        });
    }
}
