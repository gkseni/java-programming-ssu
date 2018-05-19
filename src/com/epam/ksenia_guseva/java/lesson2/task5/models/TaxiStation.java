package com.epam.ksenia_guseva.java.lesson2.task5.models;

import com.epam.ksenia_guseva.java.lesson2.task5.interfaces.Station;

import java.util.Arrays;

/**
 * Created by gkseni on 19.05.2018.
 */
public class TaxiStation implements Station {

    private Car[] taxis;

    public TaxiStation(int n) {
        taxis = new Car[n];
    }

    public Car[] getTaxis() {
        return taxis;
    }

    public void addCar(int index, Car car) {
        taxis[index] = car;
    }

    public double getTaxisCost() {
        double cost = 0;
        for (Car car : taxis) {
            cost += car.getCost();
        }
        return cost;
    }

    public void sortByFuelConsumption() {
        Arrays.sort(taxis, (taxi_1, taxi_2) -> {
            Double fuelConsumption_1 = taxi_1.getFuelConsumption();
            Double fuelConsumption_2 = taxi_2.getFuelConsumption();
            return fuelConsumption_1.compareTo(fuelConsumption_2);
        });
    }

    public void findTaxiByCost(double minCost, double maxCost) {
        double cost = 0;
        for (Car car : taxis) {
            cost += car.getCost();
            if (cost >= minCost && cost <= maxCost) {
                System.out.print("Name: " + car.getName() + " Type: " + car.getType() + " Color: " + car.getColor()
                        + " Fuel Consumption: " + car.getFuelConsumption() + " Cost: " + car.getCost() + "\n");
            }
        }
    }
}
