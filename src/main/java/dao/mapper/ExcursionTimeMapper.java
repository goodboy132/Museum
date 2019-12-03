package dao.mapper;

import entity.ExcursionTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcursionTimeMapper implements ObjectMapper<ExcursionTime> {

  @Override
  public ExcursionTime extractFromResultSet(ResultSet resultSet) throws SQLException {
    ExcursionTime excursionTime = new ExcursionTime();
    excursionTime.setId(resultSet.getLong("excursion_time.id"));
    excursionTime.setStartTime(resultSet.getTime("excursion_time.start_time"));
    excursionTime.setEndTime(resultSet.getTime("excursion_time.end_time"));
    return excursionTime;
  }
}
