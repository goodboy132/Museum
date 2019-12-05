package dao.impl;

import dao.WorkerDAO;
import dao.mapper.AuthorMapper;
import dao.mapper.HallMapper;
import dao.mapper.WorkerMapper;
import dao.mapper.WorkerPositionMapper;
import entity.Author;
import entity.Hall;
import entity.Worker;
import entity.WorkerPosition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCWorkerDAO implements WorkerDAO {
  private static JDBCWorkerDAO instance;
  private final Connection connection;

  public JDBCWorkerDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCWorkerDAO getInstance(Connection connection) {
    if (instance == null) {
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

  @Override
  public Optional<Worker> getOneById(Long elementId) {
    String getOneWorkerWithHallIdQuery = "select worker.id, worker.name, worker.surname, worker.position_id," +
            " worker.username, worker.password from worker where worker.id = ?";
    Optional<Worker> worker =
            JDBCCRADDao.getOneById(connection, getOneWorkerWithHallIdQuery, elementId, new WorkerMapper());
    setWorkerHalls(worker.get());
    setWorkerPosition(worker.get());
    System.out.println(worker);
    return null;
  }

  @Override //remake
  public List<Worker> getAll() {
    String getAllWorkersQuery = "select * from worker\n" +
            "join worker_position\n" +
            "on worker.position_id = worker_position.id";
    return JDBCCRADDao.getAll(connection, getAllWorkersQuery, new WorkerMapper());
  }

  public List<Worker> getWorkersByPosition(String positionName) {
    String getGuidesQuery = "select * from worker w join worker_position wp on w.position_id =" +
            " wp.id where wp.position_name = ?";
    List<Worker> workers = JDBCCRADDao.getAll(connection, getGuidesQuery, new WorkerMapper(), positionName);
    workers.forEach(this::setWorkerPosition);
    return workers;
  }


  private void setWorkerHalls(Worker worker){
    String setWorkerHallsQuery = "select * from hall h join worker_hall wh on h.id = wh.hall_id where wh.worker_id = ?";
    List<Hall> halls = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(setWorkerHallsQuery);
      JDBCCRADDao.addParametersToPreparedStatement(preparedStatement, worker.getId());
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        halls.add(new HallMapper().extractFromResultSet(resultSet));
      }
      worker.setHalls(halls);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
  }

  private void setWorkerPosition(Worker worker) {
    String setWorkerPositionQuery = "select * from worker_position join worker w on worker_position.id = " +
            "w.position_id where w.id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(setWorkerPositionQuery);
      JDBCCRADDao.addParametersToPreparedStatement(preparedStatement, worker.getId());
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        worker.setWorkerPosition(new WorkerPositionMapper().extractFromResultSet(resultSet));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}
