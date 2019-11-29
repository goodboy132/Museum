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
    ExcursionTime excursionDate = new ExcursionTime();
    excursion.setId(resultSet.getLong("id"));
    excursion.setTimeTable(resultSet.getString("time_table"));
    excursion.setName(resultSet.getString("excursion_name"));
    excursion.setProgram(resultSet.getString("excursion_program"));
    excursionDate.setId(resultSet.getLong("id"));
    excursionDate.setStartTime(resultSet.getTime("start_time"));
    excursionDate.setEndTime(resultSet.getTime("end_time"));
    excursion.setExcursionDate(excursionDate);
    return excursion;

  }
}
