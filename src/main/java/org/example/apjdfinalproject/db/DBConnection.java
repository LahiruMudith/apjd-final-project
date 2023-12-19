package org.example.apjdfinalproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static DBConnection dbConnection;

    private Connection connection;

    private DBConnection() {
        try {

            //load connector
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaFxMVC", "root", "1212");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getDbConnection() {
        if (dbConnection==null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}