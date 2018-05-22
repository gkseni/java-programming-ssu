package com.epam.ksenia_guseva.java.lesson8.task5.models;

import com.epam.ksenia_guseva.java.lesson8.task5.XMLworkers.Parser;

import java.io.File;

public class Station {
    private TaxiStation taxiStation = null;

    public void makeTaxiStation() {
        taxiStation = new TaxiStation();
    }

    public void addSedan() {
        taxiStation.addCar(getSedan());
    }

    private Car getCar(String carName) {
        File carPath = new File(Parser.getFile("cars.xml"));
        return Parser.getModelsFromXML(carPath, carName);
    }

    public Sedan getSedan() {
        return (Sedan) getCar("Sedan");
    }
}
