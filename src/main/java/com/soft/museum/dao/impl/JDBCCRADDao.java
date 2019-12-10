package com.soft.museum.dao.impl;

import com.soft.museum.dao.mapper.ObjectMapper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCRADDao {


  public static Integer save(Connection connection, String query, Object... parameters) throws SQLException {
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    addParametersToPreparedStatement(preparedStatement, parameters);
    return preparedStatement.executeUpdate();
}

  public static Integer update(Connection connection, String query, Object... parameters) throws SQLException {
    PreparedStatement statement = connection.prepareStatement(query);
    addParametersToPreparedStatement(statement, parameters);
    return statement.executeUpdate();
  }

  public static<T> Optional<T> getOne(Connection connection, String query,  ObjectMapper<T> mapper,
                                      Object... parameters) throws SQLException {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      if (parameters.length < 1) {
        ResultSet resultSet = preparedStatement.executeQuery();
        return Optional.of(mapper.extractFromResultSet(resultSet));
      }
      else {
        addParametersToPreparedStatement(preparedStatement, parameters);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
          return Optional.of(mapper.extractFromResultSet(resultSet));
        }
        else {
          return Optional.empty();
        }
      }
    }

  public static <T> List<T> getAll(Connection connection, String query, ObjectMapper<T> mapper, Object... parameters)
          throws SQLException {
    ArrayList<T> list = new ArrayList<>();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      if (parameters.length > 0) {
        addParametersToPreparedStatement(preparedStatement, parameters);
      }
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        list.add(mapper.extractFromResultSet(resultSet));
      }
    return list;
  }


  static void addParametersToPreparedStatement(PreparedStatement preparedStatement, Object... parameters) {
    try {
      for (int i = 0; i < parameters.length; i++) {
        if (parameters[i] instanceof String) {
          preparedStatement.setString(i + 1, (String) parameters[i]);
        } else if (parameters[i] instanceof Integer) {
          preparedStatement.setInt(i + 1, (Integer) parameters[i]);
        } else if (parameters[i] instanceof Long) {
          preparedStatement.setLong(i + 1, (Long) parameters[i]);
        } else if (parameters[i] instanceof LocalDateTime) {
          preparedStatement.setTimestamp(i + 1, Timestamp.valueOf((LocalDateTime) parameters[i]));
        } else if (parameters[i] == null) {
          preparedStatement.setNull(i + 1, Types.NULL);
        } else {
          throw new IllegalArgumentException("Not mapped type of " + parameters[i].getClass());
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
