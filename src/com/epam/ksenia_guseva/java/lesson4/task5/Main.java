package com.epam.ksenia_guseva.java.lesson4.task5;

import com.epam.ksenia_guseva.java.lesson4.task5.exceptions.WrongCostException;
import com.epam.ksenia_guseva.java.lesson4.task5.models.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        TaxiStation taxiStation = null;

        try {
            taxiStation = new TaxiStation(-10);
        } catch (Exception e) {
            System.out.println("TaxiStation: " + e.getMessage());
        }

        taxiStation = new TaxiStation(4);

        Sedan sedan = new Sedan("Skoda", "Sedan", "Red", 14, 33000);
        Hatchback hatchback = new Hatchback("BMW", "Hatchback", "Black", 20, 900000);
        Estate estate = new Estate("Audi", "Estate", "Yellow", 15, 50000);
        Estate estate_2 = new Estate("Audi", "Estate", "Yellow", 15, 20000);

        int i = 0;

        taxiStation.addCar(i, sedan);
        taxiStation.addCar(++i, hatchback);
        taxiStation.addCar(++i, estate);
        taxiStation.addCar(++i, estate_2);
    }
}
