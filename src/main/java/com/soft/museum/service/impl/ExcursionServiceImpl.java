package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.ExcursionDAO;
import com.soft.museum.dao.database.Database;
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
      Integer save = excursionDao.save(excursion);
      if (save> 0) {
        return save;
      } else {
        throw new NotSavedException(ErrorMessage.EXCURSION_NOT_SAVED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotSavedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int delete(Excursion excursion) throws NotDeletedException {
    try {
      Integer deleteExcursion = excursionDao.delete(excursion);
      if (deleteExcursion > 0) {
        return deleteExcursion;
      } else {
        throw new NotDeletedException(ErrorMessage.EXCURSION_NOT_DELETED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotDeletedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int update(Excursion excursion) throws NotUpdatedException {
    try {
      Integer update = excursionDao.update(excursion);
      if (update > 0) {
        return update;
      } else {
        throw new NotUpdatedException(ErrorMessage.EXCURSION_NOT_UPDATED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotUpdatedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Optional<Excursion> getById(Long id) throws NotFoundException {
    try {
      Optional<Excursion> oneById = excursionDao.getOneById(id);
      if (oneById.isPresent()) {
        return oneById;
      } else {
        throw new NotFoundException(ErrorMessage.EXCURSION_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<Excursion> getAll() throws NotFoundException {
    try {
      List<Excursion> all = excursionDao.getAll();
      if (!all.isEmpty()) {
        return all;
      } else {
        throw new NotFoundException(ErrorMessage.EXCURSIONS_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
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
      Integer countOfExcursionsForPeriod = excursionDao.getCountOfExcursionsForPeriod(startTime, endTime);
      if (countOfExcursionsForPeriod > 0) {
        return countOfExcursionsForPeriod;
      } else {
        throw new NotFoundException(ErrorMessage.NO_AVAILABLE_EXCURSIONS_IN_THIS_PERIOD);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }
}
