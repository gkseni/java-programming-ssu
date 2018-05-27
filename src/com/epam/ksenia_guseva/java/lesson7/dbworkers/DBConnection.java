package com.epam.ksenia_guseva.java.lesson7.dbworkers;

import com.epam.ksenia_guseva.java.lesson7.models.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DBConnection {

    void process(String dbUrl, String dbUser, String dbPass) throws ClassNotFoundException;

    void close() throws SQLException;

    Connection getConnection();
}
