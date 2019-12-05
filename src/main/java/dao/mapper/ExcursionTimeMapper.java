package dao.mapper;

import entity.ExcursionTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcursionTimeMapper implements ObjectMapper<ExcursionTime> {
  @Override
  public ExcursionTime extractFromResultSet(ResultSet resultSet) throws SQLException {
    ExcursionTime excursionTime = new ExcursionTime();
    excursionTime.setId(resultSet.getLong("excursion_time.id"));
    excursionTime.setStartTime(resultSet.getTimestamp("excursion_time.start_time").toLocalDateTime());
    excursionTime.setEndTime(resultSet.getTimestamp("excursion_time.end_time").toLocalDateTime());
    return excursionTime;
  }
}
