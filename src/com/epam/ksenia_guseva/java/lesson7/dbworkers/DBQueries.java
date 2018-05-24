package com.epam.ksenia_guseva.java.lesson7.dbworkers;

import com.epam.ksenia_guseva.java.lesson7.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBQueries {

    public static void insertRecord(DBConnector dbConnector, Employee employee) throws Exception {

        Connection connection = dbConnector.getConnection();
        connection.setAutoCommit(false);

        String insertTable = "INSERT INTO employees.employees"
                + "(NAME, AGE, POSITION)" + "VALUES"
                + "(?, ?, ?)";


        PreparedStatement preparedStatement = connection.prepareStatement(insertTable);

        preparedStatement.setString(1, employee.getName());
        preparedStatement.setInt(2, employee.getAge());
        preparedStatement.setString(3, employee.getPosition());
        preparedStatement.executeUpdate();

        connection.commit();
        connection.close();
    }
}
