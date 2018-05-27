package com.epam.ksenia_guseva.java.lesson7.dbworkers;

import com.epam.ksenia_guseva.java.lesson7.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Employee> selectEmployees(DBConnector connector) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = connector.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT  * FROM employees.employees");
        while (result.next()) {
            Employee employee = new Employee();
            employee.setName(result.getString("NAME"));
            employee.setAge(result.getInt("AGE"));
            employee.setPosition(result.getString("POSITION"));
            employeeList.add(employee);
        }
        statement.close();

        return employeeList;
    }
}
