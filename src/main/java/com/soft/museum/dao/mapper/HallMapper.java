package com.soft.museum.dao.mapper;

import com.soft.museum.entity.Hall;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HallMapper implements ObjectMapper<Hall> {
  @Override
  public Hall extractFromResultSet(ResultSet resultSet) throws SQLException {
    Hall hall = new Hall();
    hall.setId(resultSet.getLong("id"));
    hall.setName(resultSet.getString("hall_name"));
    return hall;
  }
}
