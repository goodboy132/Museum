package com.soft.museum.service.impl;

import com.soft.museum.dao.WorkerDAO;
import com.soft.museum.dao.databace.Database;
import com.soft.museum.dao.impl.JDBCWorkerDAO;
import com.soft.museum.entity.Worker;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;
import com.soft.museum.service.WorkerService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class WorkerServiceImpl implements WorkerService {

  private WorkerDAO workerDAO;

  public WorkerServiceImpl() {
    workerDAO = JDBCWorkerDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(Worker worker) throws NotSavedException {
    try {
      return workerDAO.save(worker);
    } catch (SQLException e) {
      throw new NotSavedException(e.getMessage());
    }
  }

  @Override
  public int update(Worker worker) throws NotUpdatedException {
    try {
      return workerDAO.update(worker);
    } catch (SQLException e) {
      throw new NotUpdatedException(e.getMessage());
    }
  }

  @Override
  public int delete(Worker worker) throws NotDeletedException {
    try {
      return workerDAO.delete(worker);
    } catch (SQLException e) {
      throw new NotDeletedException(e.getMessage());
    }
  }

  @Override
  public Optional<Worker> getOneById(Long id) throws NotFoundException {
    try {
      return workerDAO.getOneById(id);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Worker> getAll() throws NotFoundException {
    try {
      return workerDAO.getAll();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Worker> getAllByPosition(String position) throws NotFoundException {
    try {
      return workerDAO.getWorkersByPosition(position);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws NotFoundException {
    try {
      return workerDAO.getFreeGuidesForPeriod(startTime,endTime);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }
}
