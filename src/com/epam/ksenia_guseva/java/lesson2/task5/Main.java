package com.epam.ksenia_guseva.java.lesson2.task5;

import com.epam.ksenia_guseva.java.lesson2.task5.models.*;


public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Sedan sedan = new Sedan("Skoda", "Sedan", "Red", 14, 33000);
        Hatchback hatchback = new Hatchback("BMW", "Hatchback", "Black", 15, 900000);
        Estate estate = new Estate("Audi", "Estate", "Yellow", 15, 50000);

        Station station = new Station(4);

        int i = 0;

        station.add(++i, sedan);
        station.add(++i, hatchback);
        station.add(++i, estate);

        this.displayTaxis(station.getTaxis());

//      System.out.println("Taxis cost: ");
//      System.out.println(station.getTaxisCost());
//      System.out.println();


    }

    public void displayTaxis(Car taxis[]) {
        for (Car car: taxis) {
            displayTaxi(car);
        }
        System.out.println();
    }

    public void displayTaxi(Car taxi) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Name: ").append(taxi.getName()).append(" ")
                .append("Type: ").append(taxi.getType()).append(" ")
                .append("Color: ").append(taxi.getColor()).append(" ")
                .append("Fuel Consumption: ").append(taxi.getFuelConsumption()).append(" ")
                .append("Cost: ").append(taxi.getCost());
        System.out.println(stringBuilder);
    }

}
