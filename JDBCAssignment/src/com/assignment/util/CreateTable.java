package com.assignment.util;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {

    public static void createStudentTable() {

        String sql ="CREATE TABLE IF NOT EXISTS student("
               +"id SERIAL PRIMARY KEY,"
               +"name VARCHAR(100),"
               +"email VARCHAR(100),"
               +"marks INT"
               +")";

        try (
                Connection con = DBUtil.getConnection();
                Statement stmt = con.createStatement();
        ) {

            stmt.executeUpdate(sql);

            System.out.println("Student Table Created");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}