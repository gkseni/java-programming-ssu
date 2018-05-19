package com.epam.ksenia_guseva.java.lesson2.task5.interfaces;

import com.epam.ksenia_guseva.java.lesson2.task5.models.Car;

public interface Station {

    void addCar(int index, Car car);

    double getTaxisCost();

    void sortByFuelConsumption();

    void findTaxiByCost(double min, double max);
}
