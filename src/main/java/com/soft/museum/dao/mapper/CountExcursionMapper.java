package com.soft.museum.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountExcursionMapper implements ObjectMapper<Integer> {
  @Override
  public Integer extractFromResultSet(ResultSet resultSet) throws SQLException {
    Integer count = resultSet.getInt("count_rows");
    return count;
  }
}
