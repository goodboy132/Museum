package com.soft.museum.dao.mapper;

import com.soft.museum.entity.Excursion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcursionMapper implements ObjectMapper<Excursion> {
  @Override
  public Excursion extractFromResultSet(ResultSet resultSet) throws SQLException {
    Excursion excursion = new Excursion();
    excursion.setId(resultSet.getLong("id"));
    excursion.setName(resultSet.getString("excursion_name"));
    excursion.setProgram(resultSet.getString("excursion_program"));
    return excursion;

  }
}
