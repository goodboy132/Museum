package com.soft.museum.dao.mapper;

import com.soft.museum.entity.Exhibit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExhibitMapper implements ObjectMapper<Exhibit> {
  @Override
  public Exhibit extractFromResultSet(ResultSet resultSet) throws SQLException {
    Exhibit exhibit = new Exhibit();
    exhibit.setId(resultSet.getLong("id"));
    exhibit.setName(resultSet.getString("exhibit_name"));
    exhibit.setReceiptDate(resultSet.getTimestamp("receipt_date").toLocalDateTime());
    exhibit.setDescription(resultSet.getString("description"));
    return exhibit;
  }
}
