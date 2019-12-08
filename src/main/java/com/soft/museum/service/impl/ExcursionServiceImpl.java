package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.ExcursionDAO;
import com.soft.museum.dao.databace.Database;
import com.soft.museum.dao.impl.JDBCExcursionDao;
import com.soft.museum.entity.Excursion;
import com.soft.museum.exception.*;
import com.soft.museum.service.ExcursionService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ExcursionServiceImpl implements ExcursionService {
  private ExcursionDAO excursionDao;

  public ExcursionServiceImpl() {
    excursionDao = JDBCExcursionDao.getInstance(Database.getConnection());
  }

  @Override
  public int save(Excursion excursion) throws NotSavedException {
    try {
      return excursionDao.save(excursion);
    } catch (SQLException e) {
      throw new NotSavedException(e.getMessage());
    }
  }

  @Override
  public int delete(Excursion excursion) throws NotDeletedException {
    try {
      return excursionDao.delete(excursion);
    } catch (SQLException e) {
      throw new NotDeletedException(e.getMessage());
    }
  }

  @Override
  public int update(Excursion excursion) throws NotUpdatedException {
    try {
      return excursionDao.update(excursion);
    } catch (SQLException e) {
      throw new NotUpdatedException(e.getMessage());
    }
  }

  @Override
  public Optional<Excursion> getById(Long id) throws NotFoundException {
    try {
      return excursionDao.getOneById(id);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Excursion> getAll() throws NotFoundException {
    try {
      return excursionDao.getAll();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime)
          throws NotFoundException {
    try {
      List<Excursion> availableExcursionsForPeriod = excursionDao.getAvailableExcursionsForPeriod(startTime, endTime);
      if (!availableExcursionsForPeriod.isEmpty()) {
        return availableExcursionsForPeriod;
      } else {
        throw new NotFoundException(ErrorMessage.NO_AVAILABLE_EXCURSIONS_IN_THIS_PERIOD);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Integer getCountOfExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime)
          throws NotFoundException {
    try {
      return excursionDao.getCountOfExcursionsForPeriod(startTime, endTime);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }
}
