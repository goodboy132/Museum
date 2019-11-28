package dao.databace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
  private static Connection connection;
  private static final String URL = "jdbc:mysql://localhost:3306/museum?serverTimezone=UTC";
  private static final String USER = "root";
  private static final String PASSWORD = "root";

  public static synchronized Connection getConnection(){
    if (connection == null){
      try {
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }
}
