package com.soft.museum.dao.mapper;

import com.soft.museum.entity.TimeTable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeTableMapper implements ObjectMapper<TimeTable> {
  @Override
  public TimeTable extractFromResultSet(ResultSet resultSet) throws SQLException {
    TimeTable timeTable = new TimeTable();
    timeTable.setId(resultSet.getLong("id"));
    timeTable.setStartTime(resultSet.getTimestamp("start_time").toLocalDateTime());
    timeTable.setEndTime(resultSet.getTimestamp("end_time").toLocalDateTime());
    return timeTable;
  }
}
