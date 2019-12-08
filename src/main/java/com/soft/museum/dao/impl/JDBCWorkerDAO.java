package com.soft.museum.dao.impl;

import com.soft.museum.dao.WorkerDAO;
import com.soft.museum.dao.mapper.*;
import com.soft.museum.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
  public Integer save(Worker element) throws SQLException {
    String saveWorkerQuery = "insert into worker(name, surname, position_id, username, password) values(?,?,?,?,?)";
    return JDBCCRADDao.save(connection, saveWorkerQuery, element.getFirstName(), element.getLastName(), element.getWorkerPosition().getId(), element.getLogin(), element.getPassword());
  }

  @Override
  public Integer update(Worker element) throws SQLException {
    String updateWorkerQuery = "update worker set name = ?, surname = ?, position_id = ?, username = ?, password = ? where id = ?";
    return JDBCCRADDao.update(connection, updateWorkerQuery, element.getFirstName(), element.getLastName(), element.getWorkerPosition().getId(), element.getLogin(), element.getPassword(), element.getId());
  }

  @Override
  public Integer delete(Worker element) throws SQLException {
    String deleteWorkerQuery = "delete from worker where worker.id = ?";
    return JDBCCRADDao.update(connection, deleteWorkerQuery, element.getId());
  }

  @Override
  public Optional<Worker> getOneById(Long elementId) throws SQLException {
    String getOneWorkerWithHallIdQuery = "select worker.id, worker.name, worker.surname, worker.position_id," +
            " worker.username, worker.password from worker where worker.id = ?";
    Optional<Worker> worker =
            JDBCCRADDao.getOne(connection, getOneWorkerWithHallIdQuery, elementId, new WorkerMapper());
    if (worker.isPresent()) {
      setMappedFieldsToWorker(worker.get());
    }
    return worker;
  }

  @Override
  public List<Worker> getAll() throws SQLException {
    String getAllWorkersQuery = "select * from worker join worker_position on worker.position_id = worker_position.id";
    List<Worker> workers = JDBCCRADDao.getAll(connection, getAllWorkersQuery, new WorkerMapper());
    for (Worker worker : workers) {
      setMappedFieldsToWorker(worker);
    }
    return workers;
  }

  public List<Worker> getWorkersByPosition(String positionName) throws SQLException {
    String getGuidesQuery = "select * from worker w join worker_position wp on w.position_id =" +
            " wp.id where wp.position_name = ?";
    List<Worker> workers = JDBCCRADDao.getAll(connection, getGuidesQuery, new WorkerMapper(), positionName);
    if (!workers.isEmpty()) {
      for (Worker worker : workers) {
        setMappedFieldsToWorker(worker);
      }
    }
    return workers;
  }

  public List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
    String getAvailableGuidesQuery = "select * from worker w join worjker_position wp on w.position_id " +
            "= wp.id join excursion e on w.id = e.worker_id join time_table tt on   e.id = tt.excursion_id " +
            "where wp.position_name = 'GUIDE' and tt.start_time not between ? and ?";
    List<Worker> workers = JDBCCRADDao.getAll(connection, getAvailableGuidesQuery, new WorkerMapper(), startTime, endTime);
    if (!workers.isEmpty()) {
      for (Worker worker : workers) {
        setMappedFieldsToWorker(worker);
      }
    }
    return workers;
  }

  private void setMappedFieldsToWorker(Worker worker) throws SQLException {
    setWorkerExcursions(worker);
    setWorkerPosition(worker);
    setWorkerHalls(worker);
  }


  private void setWorkerHalls(Worker worker) throws SQLException {
    String setWorkerHallsQuery = "select * from hall h join worker_hall wh on h.id = wh.hall_id where wh.worker_id = ?";
    List<Hall> halls = JDBCCRADDao.getAll(connection, setWorkerHallsQuery, new HallMapper(), worker.getId());
    worker.setHalls(halls);
  }

  private void setWorkerPosition(Worker worker) throws SQLException {
    String setWorkerPositionQuery = "select * from worker_position join worker w on worker_position.id = " +
            "w.position_id where w.id = ?";
    Optional<WorkerPosition> position = JDBCCRADDao.getOne
            (connection, setWorkerPositionQuery, worker.getId(), new WorkerPositionMapper());
    worker.setWorkerPosition(position.get());
  }

  private void setWorkerExcursions(Worker worker) throws SQLException {
    String setWorkerExcursionsQuery = "select * from excursion e where e.worker_id = ?";
    List<Excursion> excursions = JDBCCRADDao.getAll
            (connection, setWorkerExcursionsQuery, new ExcursionMapper(), worker.getId());
    worker.setExcursions(excursions);
  }
}
