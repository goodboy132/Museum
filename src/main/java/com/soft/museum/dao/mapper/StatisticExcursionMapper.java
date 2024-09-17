package com.soft.museum.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StatisticExcursionMapper implements ObjectMapper<Map<String, Integer>> {

  @Override
  public Map<String, Integer> extractFromResultSet(ResultSet resultSet) throws SQLException {
    Map<String, Integer> result = new HashMap<>();
    while (resultSet.next()) {
      result.put(resultSet.getString("name") + " " + resultSet.getString("surname"),
              resultSet.getInt("count_rows"));
    }
    return result;
  }
}
