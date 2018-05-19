package com.epam.ksenia_guseva.java.lesson1.task3;

import java.util.Scanner;

/**
 * Created by gkseni on 19.05.2018.
 */
public class Task3 {
    public static void main(String[] args) {
        Task3 app = new Task3();
        app.startTask3();
    }

    public void startTask3() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter numbers a and b:");
        System.out.print("a = ");
        double a = in.nextInt();
        System.out.print("b = ");
        double b = in.nextInt();

        System.out.println("Enter number of command, please:");
        System.out.println("1: a + b\n" +
                "2: a - b\n" +
                "3: a * b\n" +
                "4: a \\ b\n");

        int command = in.nextInt();
        switch (command) {
            case 1:
                System.out.println("a + b = " + sum(a, b));
                break;
            case 2:
                System.out.println("a - b = " + dif(a, b));
                break;
            case 3:
                System.out.println("a * b = " + mul(a, b));
                break;
            case 4:
                System.out.println("a / b = " + div(a, b));
                break;
            default:
                System.out.println("Enter correct command, please");
                break;
        }
    }

    double sum(double a, double b) {
        return a + b;
    }

    double dif(double a, double b) {
        return a - b;
    }

    double mul(double a, double b) {
        return a * b;
    }

    double div(double a, double b) {
        return a / b;
    }
}
