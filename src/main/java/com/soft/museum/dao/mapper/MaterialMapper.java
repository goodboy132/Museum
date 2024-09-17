package com.soft.museum.dao.mapper;

import com.soft.museum.entity.Material;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialMapper implements ObjectMapper<Material> {
  @Override
  public Material extractFromResultSet(ResultSet resultSet) throws SQLException {
    Material material = new Material();
    material.setId(resultSet.getLong("id"));
    material.setName(resultSet.getString("material_name"));
    return material;
  }
}
