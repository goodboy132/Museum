package com.soft.museum.dao.mapper;

import com.soft.museum.entity.WorkerPosition;
import com.soft.museum.entity.enums.WorkerPositions;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerPositionMapper implements ObjectMapper<WorkerPosition> {

  @Override
  public WorkerPosition extractFromResultSet(ResultSet resultSet) throws SQLException {
    WorkerPosition workerPosition = new WorkerPosition();
    workerPosition.setId(resultSet.getLong("id"));
    workerPosition.setPositionName(WorkerPositions.valueOf(resultSet.getString("position_name")));
    return workerPosition;
  }
}
