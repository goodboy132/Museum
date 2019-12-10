package com.soft.museum.dao.mapper;

import com.soft.museum.entity.HallStyle;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HallStyleMapper implements ObjectMapper<HallStyle> {

  @Override
  public HallStyle extractFromResultSet(ResultSet resultSet) throws SQLException {
    HallStyle hallStyle = new HallStyle();
    hallStyle.setId(resultSet.getLong("id"));
    hallStyle.setName(resultSet.getString("hall_style_name"));
    return hallStyle;
  }
}
