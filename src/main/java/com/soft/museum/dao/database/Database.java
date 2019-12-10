package com.soft.museum.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
  private static Connection connection;
  private static final String URL = "jdbc:mysql://localhost:3306/museum?serverTimezone=UTC&useSSL=false";
  private static final String USER = "root";
  private static final String PASSWORD = "root";

  public static synchronized Connection getConnection(){
    if (connection == null){
      try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return connection;
  }
}
