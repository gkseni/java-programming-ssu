package com.epam.ksenia_guseva.java.lesson7.dbworkers;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {

    void process(String dbUrl, String dbUser, String dbPass) throws ClassNotFoundException;

    void close() throws SQLException;

    Connection getConnection();
}
