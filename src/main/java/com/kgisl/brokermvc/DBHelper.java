package com.kgisl.brokermvc;
import java.sql.*;
import
public class DBHelper{
    public static void pushBrokerage(Brokerage entity){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException cnf){
            System.out.println("Problem with Loding JDBC Driver");
        }
    }
}