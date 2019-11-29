package dao.mapper;

import entity.WorkerPosition;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerPositionMapper implements ObjectMapper<WorkerPosition> {

  @Override
  public WorkerPosition extractFromResultSet(ResultSet resultSet) throws SQLException {
    WorkerPosition workerPosition = new WorkerPosition();

    workerPosition.setId(resultSet.getLong("worker_position.id"));
    workerPosition.setName(resultSet.getString("worker_position.position_name"));

    return workerPosition;
  }
}
