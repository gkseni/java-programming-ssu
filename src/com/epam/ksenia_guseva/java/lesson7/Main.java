package com.epam.ksenia_guseva.java.lesson7;

import com.epam.ksenia_guseva.java.lesson7.dbworkers.DBConnector;
import com.epam.ksenia_guseva.java.lesson7.dbworkers.DBQueries;
import com.epam.ksenia_guseva.java.lesson7.models.Employee;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {

        DBConnector dbConnector = new DBConnector();
        dbConnector.process("jdbc:mysql://localhost:3306/employees", "java", "epam");
        Employee employee = new Employee("VASYA", 30, "Designer");
        DBQueries.insertRecord(dbConnector, employee);
        System.out.println("Employee was added");
    }
}
