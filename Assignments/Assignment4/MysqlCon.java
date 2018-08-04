package com.ThreadAssignment;

import java.sql.*;
class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/sonoo","root","rishav123");
//here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");

         //   rs.next();

            while (rs.next())
            {
                DbObject dbObject = new DbObject();
                dbObject.setId(rs.getInt(1));
                dbObject.setName(rs.getString(2));
                dbObject.setAge(rs.getInt(3));

                System.out.println(dbObject.getAge());
                System.out.println(dbObject.getId());
                System.out.println(dbObject.getName());
            }

          /*  while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            } */
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}  