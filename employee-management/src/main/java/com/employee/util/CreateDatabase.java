package com.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {

    public static void createDB() {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Ria@123";   // put your real password

        try {

            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            stmt.executeUpdate("CREATE DATABASE employee_db");

            System.out.println("Database created successfully");

            stmt.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Error while creating database:");
            e.printStackTrace();   // THIS IS IMPORTANT
        }
    }
}