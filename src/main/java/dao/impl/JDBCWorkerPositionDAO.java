package dao.impl;

import dao.WorkerPositionDAO;
import dao.mapper.WorkerPositionMapper;
import entity.WorkerPosition;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class JDBCWorkerPositionDAO implements WorkerPositionDAO {
  private static JDBCWorkerPositionDAO instance;
  private final Connection connection;

  public JDBCWorkerPositionDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCWorkerPositionDAO getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCWorkerPositionDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(WorkerPosition element) {
    String saveWorkerPositionQuery = "insert into worker_position(position_name) values(?)";
    return JDBCCRADDao.save(connection, saveWorkerPositionQuery, element.getName());
  }

  @Override
  public Integer update(WorkerPosition element) {
    String updateWorkerPositionQuery = "update worker_position set position_name = ? where id = ?";
    return JDBCCRADDao.update(connection, updateWorkerPositionQuery, element.getName(), element.getId());
  }

  @Override
  public Integer delete(WorkerPosition element) {
    String deleteWorkerPositionQuery = "delete from worker_position where id = ?";
    return JDBCCRADDao.update(connection, deleteWorkerPositionQuery, element.getId());
  }

  @Override
  public Optional<WorkerPosition> getOneById(Long elementId) {
    String getOneWorkerPositionQuery = "select * from worker_position where id = ?";
    return JDBCCRADDao.getOneById(connection, getOneWorkerPositionQuery, elementId, new WorkerPositionMapper());
  }

  @Override
  public List<WorkerPosition> getAll() {
    String getAllWorkerPositionsQuery = "select * from worker_position";
    return JDBCCRADDao.getAll(connection, getAllWorkerPositionsQuery, new WorkerPositionMapper());
  }
}
