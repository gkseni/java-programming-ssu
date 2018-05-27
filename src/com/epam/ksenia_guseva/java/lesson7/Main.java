package com.epam.ksenia_guseva.java.lesson7;

import com.epam.ksenia_guseva.java.lesson7.dbworkers.DBConnection;
import com.epam.ksenia_guseva.java.lesson7.dbworkers.DBConnector;
import com.epam.ksenia_guseva.java.lesson7.dbworkers.DBQueries;
import com.epam.ksenia_guseva.java.lesson7.models.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {

        DBConnector dbConnector = new DBConnector();
        dbConnector.process("jdbc:mysql://localhost:3306/employees", "java", "epam");
        DBQueries.insertRecord(dbConnector, new Employee("VASYA", 30, "Designer"));
        DBQueries.insertRecord(dbConnector, new Employee("VITYA", 27, "UI Engineer"));
        List<Employee> employeeList = DBQueries.selectEmployees(dbConnector);
        for (int j = 0; j < employeeList.size(); j++) {
            for (int k = 0; k < 10; k++) {
                DBQueries.insertRecord(dbConnector, employeeList.get(j));
            }
        }
        System.out.println("Employee was added");
    }
}
