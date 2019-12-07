package com.soft.museum.dao.mapper;

import com.soft.museum.entity.Technique;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TechniqueMapper implements ObjectMapper<Technique> {
  @Override
  public Technique extractFromResultSet(ResultSet resultSet) throws SQLException {
    Technique technique = new Technique();
    technique.setId(resultSet.getLong("id"));
    technique.setName(resultSet.getString("technique_name"));
    return technique;
  }
}
