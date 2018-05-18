package com.epam.ksenia_guseva.java.lesson2.task5.interfaces;

import com.epam.ksenia_guseva.java.lesson2.task5.models.Car;

public interface TaxiStation {

    public void add(int index, Car car);
    public double getTaxisCost();
    public Car[] findCarByCost(double costMin, double costMax);
    public void sort();
}
