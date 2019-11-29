package dao.impl;

import dao.mapper.ObjectMapper;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JDBCCRADDao {


  public static Integer save(Connection connection, String query,Object... parameters) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      addParametersToPreparedStatement(preparedStatement,parameters);
      return preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void update(Object element) {

  }

  public static void delete(Object element) {

  }

  public static<T> Optional<T> getOneById(Connection connection, String query, Long elementId, ObjectMapper<T> mapper) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      addParametersToPreparedStatement(preparedStatement,elementId);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()){
        return Optional.of(mapper.extractFromResultSet(resultSet));
      }
      else {
        return Optional.empty();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  public static List getAll() {
    return null;
  }


  private static void addParametersToPreparedStatement(PreparedStatement preparedStatement, Object... parameters){
    try {
      for (int i = 0; i < parameters.length; i++) {
         if (parameters[i] instanceof String) {
          preparedStatement.setString(i + 1, (String) parameters[i]);
        }
        else if (parameters[i] instanceof Integer) {
          preparedStatement.setInt(i + 1, (Integer) parameters[i]);
        }
        else if (parameters[i] instanceof Long) {
          preparedStatement.setLong(i + 1, (Long) parameters[i]);
        }
         else if (parameters[i] instanceof Date) {
           preparedStatement.setTimestamp(i + 1, new Timestamp(((Date) parameters[i]).getTime()));
         }
        else if (parameters[i] == null) {
          preparedStatement.setNull(i + 1, Types.NULL);
        }

        else {
          throw new IllegalArgumentException("Not mapped type of " + parameters[i].getClass());
        }
      }
    }
    catch (SQLException e){
      e.printStackTrace();
    }
  }

}
