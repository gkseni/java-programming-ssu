package com.epam.ksenia_guseva.java.lesson8;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {

        TaxiStation taxiStation = new TaxiStation();

        taxiStation.makeTaxis();

        taxiStation.addSedan();
        taxiStation.addSedan();
        taxiStation.addSedan();

        taxiStation.displayStation();
    }
}
