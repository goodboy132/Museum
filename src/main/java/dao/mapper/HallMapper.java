package dao.mapper;

import entity.Hall;
import entity.HallStyle;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HallMapper implements ObjectMapper<Hall> {
  @Override
  public Hall extractFromResultSet(ResultSet resultSet) throws SQLException {
    Hall hall = new Hall();
    HallStyle hallStyle = new HallStyle();
    hall.setId(resultSet.getLong("hall.id"));
    hall.setName(resultSet.getString("hall.hall_name"));

    hallStyle.setId(resultSet.getLong("hall_style.id"));
    hallStyle.setName(resultSet.getString("hall_style.hall_style_name"));

    hall.setHallStyle(hallStyle);
    return hall;
  }
}
