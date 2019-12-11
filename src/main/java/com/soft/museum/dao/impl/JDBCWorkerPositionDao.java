package com.soft.museum.dao.impl;

import com.soft.museum.dao.WorkerPositionDAO;
import com.soft.museum.dao.mapper.WorkerPositionMapper;
import com.soft.museum.entity.WorkerPosition;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCWorkerPositionDao implements WorkerPositionDAO {

  private static JDBCWorkerPositionDao instance;
  private final Connection connection;

  public JDBCWorkerPositionDao(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCWorkerPositionDao getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCWorkerPositionDao(connection);
    }
    return instance;
  }


  @Override
  public Integer save(WorkerPosition element) throws SQLException {
    return null;
  }

  @Override
  public Integer update(WorkerPosition element) throws SQLException {
    return null;
  }

  @Override
  public Integer delete(WorkerPosition element) throws SQLException {
    return null;
  }

  @Override
  public Optional<WorkerPosition> getOneById(Long elementId) throws SQLException {
    return Optional.empty();
  }

  @Override
  public List<WorkerPosition> getAll() throws SQLException {
    String getAllPositionQuery = "select * from worker_position";
    return JDBCCRUDDao.getAll(connection,getAllPositionQuery,new WorkerPositionMapper());
  }
}
