package com.epam.ksenia_guseva.java.lesson5.task5;

import com.epam.ksenia_guseva.java.lesson5.task5.models.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Sedan sedan = new Sedan("Skoda", "Sedan", "Red", 14, 33000);
        Sedan sedan_2 = new Sedan("Skoda", "Sedan", "Aqua", 8, 33000);
        Sedan sedan_3 = new Sedan("Audi", "Sedan", "Black", 18, 1000000);
        Sedan sedan_4 = new Sedan("Skoda", "Sedan", "Red", 6, 50000);
        Sedan sedan_5 = new Sedan("Lada", "Sedan", "Eggplant", 5, 30000);
        Hatchback hatchback = new Hatchback("BMW", "Hatchback", "Black", 15, 900000);
        Estate estate = new Estate("Audi", "Estate", "Yellow", 15, 50000);

        Station station = new Station();

        station.add(sedan);
        station.add(sedan_2);
        station.add(sedan_3);
        station.add(sedan_4);
        station.add(sedan_5);
        station.add(hatchback);
        station.add(estate);


        System.out.println("Taxi station costs: ");
        System.out.println(station.getTaxisCost());
        System.out.println();

        System.out.println("All cars: ");
        this.printTaxis(station.getTaxis());
        System.out.println();

        station.sort();
        System.out.println("Sort by Fuel Consumption:");
        this.printTaxis(station.getTaxis());

        System.out.println();
        System.out.println("Find car by color: Red");
        this.printTaxis(station.findCarByColor("Red"));

    }

    private void printTaxis(List<Car> taxis) {
        taxis.forEach(this::printCar);
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
}
