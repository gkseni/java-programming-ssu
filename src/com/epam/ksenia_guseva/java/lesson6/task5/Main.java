package com.epam.ksenia_guseva.java.lesson6.task5;

import com.epam.ksenia_guseva.java.lesson6.task5.models.*;
import com.epam.ksenia_guseva.java.lesson6.task5.utils.ConnectorClass;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final String filePath = "src/com/epam/ksenia_guseva/java/lesson6/task5/";

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        serialize();
        deserialize();
    }

    private void serialize() {
        Station station = makeStation();
        serializeTaxis(station);
    }

    private void deserialize() {
        Station station = deserializeTaxis("cars.txt");
        System.out.println("Taxis: ");
        dislayTaxis(station.getTaxis());
    }

    private Station makeStation() {
        Sedan sedan = new Sedan("Skoda", "Sedan", "Red", 14, 1466000);
        Sedan sedan2 = new Sedan("Skoda", "Sedan", "Red", 14, 1466000);
        Sedan sedan3 = new Sedan("Skoda", "Sedan", "Red", 14, 1466000);

        Station station = new Station();

        station.addCar(sedan);
        station.addCar(sedan2);
        station.addCar(sedan3);

        return station;
    }

    void dislayTaxis(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private void printCar(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Name: ").append(car.getName()).append(" ")
                .append("Type: ").append(car.getType()).append(" ")
                .append("Color: ").append(car.getColor()).append(" ")
                .append("Fuel Consumption: ").append(car.getFuelConsumption()).append(" ")
                .append("Cost: ").append(car.getCost());
        System.out.println(stringBuilder);
    }

    private void serializeTaxis(Station station) {
        File stationFile = new File(filePath + "cars.txt");
        ConnectorClass.addObjectToFile(stationFile, station);
    }

    private Station deserializeTaxis(String fName) {
        File stationFile = new File(filePath + fName);
        return (Station) ConnectorClass.readObjectFromFile(stationFile);
    }
}
