package com.ThreadAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;


public class AssignmentThread {

    private static final String QUERY = "select * from emp";
    private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sonoo";
    private static final String USER = "root";
    private static final String PASSWORD = "rishav123";


    public static void main(String[] args)
            throws InterruptedException {


        try{
            Class.forName(DRIVERCLASS);
            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = con.createStatement();
            ResultSet resultSet=statement.executeQuery(QUERY);

            //   rs.next();

            while (resultSet.next()) {
                DbObject dbObject = new DbObject();
                dbObject.setId(resultSet.getInt(1));
                dbObject.setName(resultSet.getString(2));
                dbObject.setAge(resultSet.getInt(3));

                System.out.println(dbObject.getAge());
                System.out.println(dbObject.getId());
                System.out.println(dbObject.getName());


                //PC class has consumer and producer
        final PC pc = new PC();

        // Create producer thread
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce(dbObject);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume(dbObject);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

                // Start both threads
                thread1.start();
                thread2.start();

                // t1 finishes before t2
                thread1.join();
                thread2.join();


            }

          /*  while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            } */


            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }


}