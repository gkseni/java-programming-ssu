package com.epam.ksenia_guseva.java.lesson8;

import com.epam.ksenia_guseva.java.lesson8.XMLWorkers.Helper;
import com.epam.ksenia_guseva.java.lesson8.XMLWorkers.XMLParser;
import com.epam.ksenia_guseva.java.lesson8.models.*;

import java.io.File;
import java.util.List;

public class TaxiStation {

    private Station station = null;

    public void makeTaxis() {
        station = new Station();
    }

    public void addSedan() {
        station.addCar(getSedan());
    }

    public void addHatchback() {
        station.addCar(getHatchback());
    }

    public void addEstate() {
        station.addCar(getEstate());
    }

    private Car getCar(String carName) {
        File carFile = new File(Helper.getFilePath("cars.xml"));
        return XMLParser.getCarFromXML(carFile, carName);
    }

    private void displayTaxis(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
    }

    public void displayStation() {
        displayTaxis(station.getCars());
    }

    private Sedan getSedan() {
        return (Sedan) getCar("Sedan");
    }

    private Hatchback getHatchback() {
        return (Hatchback) getCar("Hatchback");
    }

    private Estate getEstate() {
        return (Estate) getCar("Estate");
    }
}
