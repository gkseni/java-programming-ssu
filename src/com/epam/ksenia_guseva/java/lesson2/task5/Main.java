package com.epam.ksenia_guseva.java.lesson2.task5;

import com.epam.ksenia_guseva.java.lesson2.task5.models.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        TaxiStation taxiStation = new TaxiStation(4);

        Sedan sedan = new Sedan("Skoda", "Sedan", "Red", 14, 33000);
        Hatchback hatchback = new Hatchback("BMW", "Hatchback", "Black", 20, 900000);
        Estate estate = new Estate("Audi", "Estate", "Yellow", 15, 50000);
        Estate estate_2 = new Estate("Audi", "Estate", "Yellow", 15, 20000);

        int i = 0;

        taxiStation.addCar(i, sedan);
        taxiStation.addCar(++i, hatchback);
        taxiStation.addCar(++i, estate);
        taxiStation.addCar(++i, estate_2);

        System.out.println("Display taxis before any changes: ");
        displayTaxis(taxiStation.getTaxis());

        System.out.println("Taxis cost: ");
        System.out.println(taxiStation.getTaxisCost());
        System.out.println();

        System.out.println("Sorted by fuel consumption: ");
        taxiStation.sortByFuelConsumption();
        displayTaxis(taxiStation.getTaxis());

        System.out.println("Find taxi between 20000 and 900000:");
        taxiStation.findTaxiByCost(20000, 900000);
    }

    public void displayTaxis(Car taxis[]) {
        for (Car car : taxis) {
            System.out.print("Name: " + car.getName() + " Type: " + car.getType() + " Color: " + car.getColor()
                    + " Fuel Consumption: " + car.getFuelConsumption() + " Cost: " + car.getCost() + "\n");
        }
        System.out.println();
    }
}
