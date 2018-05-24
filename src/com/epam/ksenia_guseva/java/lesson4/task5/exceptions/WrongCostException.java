package com.epam.ksenia_guseva.java.lesson4.task5.exceptions;

public class WrongCostException extends Exception {

    public String getMessage() {
        return "Cost can't be negative";
    }
}
