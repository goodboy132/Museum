package dao.impl;

import dao.ExcursionDAO;
import dao.mapper.ExcursionMapper;
import dao.mapper.TimeTableMapper;
import dao.mapper.WorkerMapper;
import entity.Excursion;
import entity.Exhibit;
import entity.TimeTable;
import entity.Worker;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class JDBCExcursionDao implements ExcursionDAO {
  private static JDBCExcursionDao instance;
  private Connection connection;

  public JDBCExcursionDao(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCExcursionDao getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCExcursionDao(connection);
    }
    return instance;
  }

  @Override
  public Integer save(Excursion element) {
    String saveExcursionQuery = "insert into excursion(worker_id, excursion_name, excursion_program) values(?, ?, ?)";
    return JDBCCRADDao.save(connection, saveExcursionQuery, element.getWorker().getId(), element.getName(), element.getProgram());
  }


  @Override
  public Integer update(Excursion element) {
    String updateExcursionQuery = "update excursion set worker_id = ?, excursion_name = ?, excursion_program = ? where id = ?";
    return JDBCCRADDao.update(connection, updateExcursionQuery, element.getWorker().getId(), element.getName(), element.getProgram(), element.getId());
  }

  @Override
  public Integer delete(Excursion element) {
    String deleteExcursionQuery = "delete from excursion where id = ?";
    return JDBCCRADDao.update(connection, deleteExcursionQuery, element.getId());
  }

  @Override
  public Optional<Excursion> getOneById(Long elementId) {
    String getExcursionById = "select excursion.id, excursion_name, excursion_program from excursion where excursion.id = ?";
    Optional<Excursion> excursion = JDBCCRADDao.getOneById(connection, getExcursionById, elementId, new ExcursionMapper());
    excursion.ifPresent(this::setMappedFieldsToExhibit);
    return excursion;
  }

  @Override
  public List<Excursion> getAll() {
    String getAllExcursionsQuery = "select excursion.id, excursion_name, excursion_program from excursion";
    List<Excursion> excursions = JDBCCRADDao.getAll(connection, getAllExcursionsQuery, new ExcursionMapper());
    excursions.forEach(this::setMappedFieldsToExhibit);
    return excursions;
  }

  private void setMappedFieldsToExhibit(Excursion excursion) {
    setWorkerForExcursion(excursion);
    setTimeTableForExcursion(excursion);
  }

  private void setWorkerForExcursion(Excursion excursion) {
    String getWorkerForExcursionQuery = "select * from worker join excursion on worker.id = excursion.worker_id where " +
            "excursion.id = ?";
    Optional<Worker> worker = JDBCCRADDao.getOneById(
            connection, getWorkerForExcursionQuery, excursion.getId(), new WorkerMapper());
    excursion.setWorker(worker.get());
  }

  private void setTimeTableForExcursion(Excursion excursion) {
    String getTimeTableForExcursionQuery = "select * from time_table where time_table.excursion_id = ?";
    List<TimeTable> timeTables = JDBCCRADDao.getAll(connection, getTimeTableForExcursionQuery, new TimeTableMapper(), excursion.getId());
    excursion.setTimeTables(timeTables);
  }

  @Override
  public List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) {
    String getAvailableExcursionsForPeriodQuery = "select * from museum.excursion join museum.time_table " +
            "on museum.time_table.excursion_id = museum.excursion.id " +
            "where museum.time_table.start_time between ? and ?";
    List<Excursion> excursions = JDBCCRADDao.getAll(connection, getAvailableExcursionsForPeriodQuery, new ExcursionMapper(), startTime, endTime);
    excursions.forEach(this::setMappedFieldsToExhibit);
    return excursions;
  }

  @Override
  public Integer getCountOfExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) {
    String getCountOfExcursionsForPeriod = "select COUNT(*) as row_count from museum.excursion join museum.time_table " +
            "on museum.time_table.excursion_id = museum.excursion.id " +
            "where museum.time_table.start_time between ? and ?";
    List<Excursion> excursions = JDBCCRADDao.getAll(connection, getCountOfExcursionsForPeriod, new ExcursionMapper(), startTime, endTime);
    return excursions.size();
  }
}
