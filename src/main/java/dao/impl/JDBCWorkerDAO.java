package dao.impl;

import dao.WorkerDAO;
import dao.mapper.WorkerMapper;
import entity.Worker;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class JDBCWorkerDAO implements WorkerDAO {
  private static JDBCWorkerDAO instance;
  private final Connection connection;

  public JDBCWorkerDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCWorkerDAO getInstance(Connection connection){
    if (instance == null){
      instance = new JDBCWorkerDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(Worker element) {
    return null;
  }

  @Override
  public Integer update(Worker element) {
    return null;
  }

  @Override
  public Integer delete(Worker element) {
    return null;
  }

  @Override //remake
  public Optional<Worker> getOneById(Long elementId) {
    String getOneWorkerWithHallIdQuery = "select worker.id, worker.name, worker.surname, worker.position_id, worker.username, worker.password \n" +
            "from worker\n" +
            "join worker_position\n" +
            "on worker.position_id = worker_position.id" +
            "where worker.id = ?;";
    Optional<Worker> oneById = JDBCCRADDao.getOneById(connection, getOneWorkerWithHallIdQuery, elementId, new WorkerMapper());
    System.out.println(oneById);
    return null;
  }

  @Override //remake
  public List<Worker> getAll() {
    String getAllWorkersQuery = "select * from worker\n" +
            "join worker_position\n" +
            "on worker.position_id = worker_position.id";
    return JDBCCRADDao.getAll(connection, getAllWorkersQuery, new WorkerMapper());
  }
}
