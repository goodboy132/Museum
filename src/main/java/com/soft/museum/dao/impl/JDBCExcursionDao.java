package com.soft.museum.dao.impl;

import com.soft.museum.dao.ExcursionDAO;
import com.soft.museum.dao.mapper.CountExcursionMapper;
import com.soft.museum.dao.mapper.ExcursionMapper;
import com.soft.museum.dao.mapper.TimeTableMapper;
import com.soft.museum.dao.mapper.WorkerMapper;
import com.soft.museum.entity.Excursion;
import com.soft.museum.entity.TimeTable;
import com.soft.museum.entity.Worker;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Class, that implements special methods for
 * getting / updating Excursion objects from / in database.
 */
public class JDBCExcursionDao implements ExcursionDAO {
  private static JDBCExcursionDao instance;
  private Connection connection;

  public JDBCExcursionDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Method for getting instance of JdbcExcursionDao.
   *
   * @param connection Connection, that used for interaction with database.
   * @return instance of JdbcExcursionDao.
   */
  public synchronized static JDBCExcursionDao getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCExcursionDao(connection);
    }
    return instance;
  }

  /**
   * Method for saving object Excursion in database
   *
   * @return 1 if the save was successful
   */
  @Override
  public Integer save(Excursion element) throws SQLException {
    String saveExcursionQuery = "insert into excursion(worker_id, excursion_name, excursion_program) values(?, ?, ?)";
    return JDBCCRUDDao.
            save(connection, saveExcursionQuery, element.getWorker().getId(), element.getName(), element.getProgram());
  }

  /**
   * Method, that updates given object Excursion
   *
   * @return 1 if the update was successful
   */
  @Override
  public Integer update(Excursion element) throws SQLException {
    String updateExcursionQuery = "update excursion set worker_id = ?, excursion_name = ?, excursion_program = ?" +
            " where id = ?";
    return JDBCCRUDDao.update(connection, updateExcursionQuery, element.getWorker().getId(), element.getName(),
            element.getProgram(), element.getId());
  }

  /**
   * Method, that deletes given object Excursion
   *
   * @return 1 if the delete was successful
   */
  @Override
  public Integer delete(Excursion element) throws SQLException {
    String deleteExcursionQuery = "delete from excursion where id = ?";
    return JDBCCRUDDao.update(connection, deleteExcursionQuery, element.getId());
  }

  /**
   * Method, that returns object Excursion wrapped in Optional by id
   *
   * @return Object Author wrapped in Optional
   */
  @Override
  public Optional<Excursion> getOneById(Long elementId) throws SQLException {
    String getExcursionById = "select excursion.id, excursion_name, excursion_program from " +
            "excursion where excursion.id = ?";
    Optional<Excursion> excursion = JDBCCRUDDao.getOne(connection, getExcursionById, new ExcursionMapper(), elementId);
    if (excursion.isPresent()) {
      setMappedFieldsToExhibit(excursion.get());
    }
    return excursion;
  }

  /**
   * Method, that returns all objects of Excursion
   *
   * @return list of Excursion
   */
  @Override
  public List<Excursion> getAll() throws SQLException {
    String getAllExcursionsQuery = "select excursion.id, excursion_name, excursion_program from excursion";
    List<Excursion> excursions = JDBCCRUDDao.getAll(connection, getAllExcursionsQuery, new ExcursionMapper());
    for (Excursion excursion : excursions) {
      setMappedFieldsToExhibit(excursion);
    }
    return excursions;
  }

  /**
   * This method mapped some fields to Excursion
   *
   * @param excursion get Excursion to Excursion
   */
  private void setMappedFieldsToExhibit(Excursion excursion) throws SQLException {
    setWorkerForExcursion(excursion);
    setTimeTableForExcursion(excursion);
  }

  /**
   * This method mapped Worker to Excursion
   *
   * @param excursion get Worker to Excursion
   */
  private void setWorkerForExcursion(Excursion excursion) throws SQLException {
    String getWorkerForExcursionQuery = "select * from worker join excursion on worker.id = excursion.worker_id where" +
            " excursion.id = ?";
    Optional<Worker> worker = JDBCCRUDDao.getOne(connection, getWorkerForExcursionQuery, new WorkerMapper(),
            excursion.getId());
    excursion.setWorker(worker.get());
  }

  /**
   * This method mapped Worker to Excursion
   *
   * @param excursion get Time Table to Excursion
   */
  private void setTimeTableForExcursion(Excursion excursion) throws SQLException {
    String getTimeTableForExcursionQuery = "select * from time_table where time_table.excursion_id = ?";
    List<TimeTable> timeTables = JDBCCRUDDao.getAll(connection, getTimeTableForExcursionQuery, new TimeTableMapper(),
            excursion.getId());
    excursion.setTimeTables(timeTables);
  }

  /**
   * Method, that returns all objects of Excursions, which held in period from startTime to endTime
   *
   * @param startTime time when excursion starts
   * @param endTime   time when excursion ends
   * @return list of Excursions in this period
   */
  @Override
  public List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime)
          throws SQLException {
    String getAvailableExcursionsForPeriodQuery = "select * from museum.excursion join museum.time_table " +
            "on museum.time_table.excursion_id = museum.excursion.id " +
            "where museum.time_table.start_time  between ? and ? group by excursion.id";
    List<Excursion> excursions = JDBCCRUDDao.getAll(connection, getAvailableExcursionsForPeriodQuery,
            new ExcursionMapper(), startTime, endTime);
    if (!excursions.isEmpty()) {
      for (Excursion excursion : excursions) {
        setMappedFieldsToExhibit(excursion);
      }
    }
    return excursions;
  }

  /**
   * Method, that returns count of Excursions, which held in period from startTime to endTime
   *
   * @param startTime time when excursion starts
   * @param endTime   time when excursion ends
   * @return count of Excursions in this period
   */
  @Override
  public Integer getCountOfExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
    String getCountOfExcursionsForPeriod = "select COUNT(*) as count_rows from museum.excursion join museum.time_table"
            + " on museum.time_table.excursion_id = museum.excursion.id " +
            "where museum.time_table.start_time between ? and ?";
    Optional<Integer> count = JDBCCRUDDao.getOne(connection, getCountOfExcursionsForPeriod, new CountExcursionMapper(),
            startTime, endTime);
    return count.get();
  }

}
