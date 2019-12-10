package com.soft.museum.dao.mapper;

import com.soft.museum.dao.mapper.ObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class WorkedHoursMapper implements ObjectMapper<Map<String, LocalDateTime>> {

  @Override
  public Map<String, LocalDateTime> extractFromResultSet(ResultSet resultSet) throws SQLException {
    Map<String, LocalDateTime> result = new HashMap<>();

    while (resultSet.next()) {
      result.put(resultSet.getString("name") + " " + resultSet.getString("surname"),
              resultSet.getTimestamp("duration").toLocalDateTime());
    }
    return result;
  }
}
