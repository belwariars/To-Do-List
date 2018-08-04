package com.ThreadAssignment;
import java.sql.*;


public class SybaseDBConnection {

    static Connection con;

    private static final String QUERY = "select * from emp";
    private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sonoo";
    private static final String USER = "root";
    private static final String PASSWORD = "rishav123";


    public static Connection getConnection() {
        try {
            Class.forName(DRIVERCLASS);
            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
        }

    }



}
