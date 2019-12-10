package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.WorkerDAO;
import com.soft.museum.dao.database.Database;
import com.soft.museum.dao.impl.JDBCWorkerDAO;
import com.soft.museum.entity.Worker;
import com.soft.museum.exception.*;
import com.soft.museum.service.WorkerService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WorkerServiceImpl implements WorkerService {

  private WorkerDAO workerDAO;

  public WorkerServiceImpl() {
    workerDAO = JDBCWorkerDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(Worker worker) throws NotSavedException {
    try {
      Integer save = workerDAO.save(worker);
      if (save > 0) {
        return save;
      } else {
        throw new NotSavedException(ErrorMessage.WORKER_NOT_SAVED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotSavedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int update(Worker worker) throws NotUpdatedException {
    try {
      Integer update = workerDAO.update(worker);
      if (update > 0) {
        return update;
      } else {
        throw new NotUpdatedException(ErrorMessage.WORKER_NOT_UPDATED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotUpdatedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int delete(Worker worker) throws NotDeletedException {
    try {
      Integer deleteWorker = workerDAO.delete(worker);
      if (deleteWorker > 0) {
        return deleteWorker;
      } else {
        throw new NotDeletedException(ErrorMessage.WORKER_NOT_DELETED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotDeletedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Optional<Worker> getOneById(Long id) throws NotFoundException {
    try {
      Optional<Worker> oneById = workerDAO.getOneById(id);
      if (oneById.isPresent()) {
        return oneById;
      } else {
        throw new NotFoundException(ErrorMessage.WORKER_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<Worker> getAll() throws NotFoundException {
    try {
      List<Worker> allWorkers = workerDAO.getAll();
      if (!allWorkers.isEmpty()) {
        return allWorkers;
      } else {
        throw new NotFoundException(ErrorMessage.WORKERS_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<Worker> getAllByPosition(String position) throws NotFoundException {
    try {
      List<Worker> workersByPosition = workerDAO.getWorkersByPosition(position);
      if (!workersByPosition.isEmpty()) {
        return workersByPosition;
      } else {
        throw new NotFoundException(ErrorMessage.WORKERS_WITH_WORKER_POSITION_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws NotFoundException {
    try {
      List<Worker> freeGuidesForPeriod = workerDAO.getFreeGuidesForPeriod(startTime, endTime);
      if (!freeGuidesForPeriod.isEmpty()) {
        return freeGuidesForPeriod;
      } else {
        throw new NotFoundException(ErrorMessage.NO_FREE_TOUR_GUIDE_IN_THIS_PERIOD);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Map<String, Integer> getStatisticByExcursions() throws NotFoundException {
    try {
      Map<String, Integer> statisticByExcursions = workerDAO.getStatisticByExcursions();
      if (!statisticByExcursions.isEmpty()) {
        return statisticByExcursions;
      } else {
        throw new NotFoundException(ErrorMessage.NO_STATISTIC_ABOUT_WORKER_EXCURSION);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Map<String, LocalDateTime> getStatisticAboutWorkedHours() throws NotFoundException {
    try {
      Map<String, LocalDateTime> statisticAboutWorkedHours = workerDAO.getStatisticAboutWorkedHours();
      if (!statisticAboutWorkedHours.isEmpty()) {
        return statisticAboutWorkedHours;
      } else {
        throw new NotFoundException(ErrorMessage.NO_STATISTIC_ABOUT_WORKED_HOURS);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }
}
