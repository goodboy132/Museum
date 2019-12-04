package dao.mapper;

import entity.Author;
import entity.Exhibit;
import entity.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExhibitMapper implements ObjectMapper<Exhibit> {
  @Override
  public Exhibit extractFromResultSet(ResultSet resultSet) throws SQLException {
    Exhibit exhibit = new Exhibit();
    exhibit.setId(resultSet.getLong("id"));
    exhibit.setName(resultSet.getString("exhibit_name"));
    exhibit.setReceiptDate(resultSet.getTimestamp("receipt_date").toLocalDateTime());
    exhibit.setTechnique(resultSet.getString("technique"));
    exhibit.setDescription(resultSet.getString("description"));
    return exhibit;
  }
}
