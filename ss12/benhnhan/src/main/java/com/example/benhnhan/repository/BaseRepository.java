package com.example.benhnhan.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private Connection connection;
    private String userName = "root";
    private String password = "123456789";
    private String jdbcURL = "jdbc:mysql://localhost:3306/final_module3?useSSL=false";
    public Connection getConnectionJAVAtoDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL,userName,password);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
