package com.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    
    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            // 1. Load the hidden config.properties file
            Properties props = new Properties();
            InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("config.properties");
            
            if (input == null) {
                System.out.println("Error: Unable to find config.properties");
                return null;
            }
            props.load(input);
            
            // 2. Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 3. Connect to the domain using the hidden credentials
            connection = DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
            );
            
            System.out.println("Database connected successfully!");
            
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        
        return connection;
    }
}