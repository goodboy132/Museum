package dao.mapper;

import entity.Excursion;
import entity.ExcursionTime;
import entity.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcursionMapper implements ObjectMapper<Excursion> {
  @Override
  public Excursion extractFromResultSet(ResultSet resultSet) throws SQLException {
    Excursion excursion = new Excursion();
    ExcursionTime excursionTime = new ExcursionTime();
    excursion.setId(resultSet.getLong("id"));
    excursion.setTimeTable(resultSet.getString("time_table"));
    excursion.setName(resultSet.getString("excursion_name"));
    excursion.setProgram(resultSet.getString("excursion_program"));
    excursionTime.setId(resultSet.getLong("id"));
    excursionTime.setStartTime(resultSet.getTimestamp("start_time").toLocalDateTime());
    excursionTime.setEndTime(resultSet.getTimestamp("end_time").toLocalDateTime());
    excursion.setExcursionDate(excursionTime);
    return excursion;

  }
}
