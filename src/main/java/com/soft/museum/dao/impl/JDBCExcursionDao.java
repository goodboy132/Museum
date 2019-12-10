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
  public Integer save(Excursion element) throws SQLException {
    String saveExcursionQuery = "insert into excursion(worker_id, excursion_name, excursion_program) values(?, ?, ?)";
    return JDBCCRADDao.
            save(connection, saveExcursionQuery, element.getWorker().getId(), element.getName(), element.getProgram());
  }


  @Override
  public Integer update(Excursion element) throws SQLException {
    String updateExcursionQuery = "update excursion set worker_id = ?, excursion_name = ?, excursion_program = ?" +
            " where id = ?";
    return JDBCCRADDao.update(connection, updateExcursionQuery, element.getWorker().getId(), element.getName(),
            element.getProgram(), element.getId());
  }

  @Override
  public Integer delete(Excursion element) throws SQLException {
    String deleteExcursionQuery = "delete from excursion where id = ?";
    return JDBCCRADDao.update(connection, deleteExcursionQuery, element.getId());
  }

  @Override
  public Optional<Excursion> getOneById(Long elementId) throws SQLException {
    String getExcursionById = "select excursion.id, excursion_name, excursion_program from " +
            "excursion where excursion.id = ?";
    Optional<Excursion> excursion = JDBCCRADDao.getOne(connection, getExcursionById, new ExcursionMapper(), elementId);
    if (excursion.isPresent()) {
      setMappedFieldsToExhibit(excursion.get());
    }
    return excursion;
  }

  @Override
  public List<Excursion> getAll() throws SQLException {
    String getAllExcursionsQuery = "select excursion.id, excursion_name, excursion_program from excursion";
    List<Excursion> excursions = JDBCCRADDao.getAll(connection, getAllExcursionsQuery, new ExcursionMapper());
    for (Excursion excursion : excursions) {
      setMappedFieldsToExhibit(excursion);
    }
    return excursions;
  }

  private void setMappedFieldsToExhibit(Excursion excursion) throws SQLException {
    setWorkerForExcursion(excursion);
    setTimeTableForExcursion(excursion);
  }

  private void setWorkerForExcursion(Excursion excursion) throws SQLException {
    String getWorkerForExcursionQuery = "select * from worker join excursion on worker.id = excursion.worker_id where"+
            "excursion.id = ?";
    Optional<Worker> worker = JDBCCRADDao.getOne(
            connection, getWorkerForExcursionQuery, new WorkerMapper(), excursion.getId());
    excursion.setWorker(worker.get());
  }

  private void setTimeTableForExcursion(Excursion excursion) throws SQLException {
    String getTimeTableForExcursionQuery = "select * from time_table where time_table.excursion_id = ?";
    List<TimeTable> timeTables = JDBCCRADDao.getAll(connection, getTimeTableForExcursionQuery, new TimeTableMapper(),
            excursion.getId());
    excursion.setTimeTables(timeTables);
  }

  @Override
  public List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime)
          throws SQLException {
    String getAvailableExcursionsForPeriodQuery = "select * from museum.excursion join museum.time_table " +
            "on museum.time_table.excursion_id = museum.excursion.id " +
            "where museum.time_table.start_time between ? and ?";
    List<Excursion> excursions = JDBCCRADDao.getAll(connection, getAvailableExcursionsForPeriodQuery,
            new ExcursionMapper(), startTime, endTime);
    if (!excursions.isEmpty()) {
      for (Excursion excursion : excursions) {
        setMappedFieldsToExhibit(excursion);
      }
    }
    return excursions;
  }

  @Override
  public Integer getCountOfExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
    String getCountOfExcursionsForPeriod = "select COUNT(*) as count_rows from museum.excursion join museum.time_table"
            + "on museum.time_table.excursion_id = museum.excursion.id " +
            "where museum.time_table.start_time between ? and ?";
    Optional<Integer> count = JDBCCRADDao.getOne(connection, getCountOfExcursionsForPeriod, new CountExcursionMapper(),
            startTime, endTime);
    return count.get();
  }

}
