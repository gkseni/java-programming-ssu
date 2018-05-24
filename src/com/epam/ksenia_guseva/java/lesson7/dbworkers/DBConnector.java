package com.epam.ksenia_guseva.java.lesson7.dbworkers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector implements DBConnection {

    public Connection connection;

    public void process(String dbUrl, String dbUser, String dbPass) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306", "java", "epam");
        } catch (SQLException e) {
            System.out.println("ConnectionFactory Failed!");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("Success connection!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public void close() {
        try {
            this.connection.close();
            System.out.println("Connection closed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
