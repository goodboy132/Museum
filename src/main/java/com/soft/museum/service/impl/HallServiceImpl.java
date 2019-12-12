package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.HallDAO;
import com.soft.museum.dao.database.Database;
import com.soft.museum.dao.impl.JDBCHallDAO;
import com.soft.museum.entity.Hall;
import com.soft.museum.exception.*;
import com.soft.museum.service.HallService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class HallServiceImpl implements HallService {
  private HallDAO hallDAO;

  /**
   * Default constructor
   */
  public HallServiceImpl() {
    hallDAO = JDBCHallDAO.getInstance(Database.getConnection());
  }

  /**
   * Method for saving object Hall in database
   *
   * @return 1 if the save was successful
   */
  @Override
  public int save(Hall hall) throws NotSavedException {
    try {
      Integer save = hallDAO.save(hall);
      if (save > 0) {
        return save;
      } throw new NotSavedException(ErrorMessage.HALL_NOT_SAVED);
    } catch (SQLException e) {
      throw new NotSavedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that updates given object Hall
   *
   * @return 1 if the update was successful
   */
  @Override
  public int update(Hall hall) throws NotUpdatedException {
    try {
      Integer update = hallDAO.update(hall);
      if (update > 0) {
        return update;
      } else {
        throw new NotUpdatedException(ErrorMessage.HALL_NOT_UPDATED);
      }
    } catch (SQLException e) {
      throw new NotUpdatedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that deletes given object Hall
   *
   * @return 1 if the delete was successful
   */
  @Override
  public int delete(Hall hall) throws NotDeletedException {
    try {
      Integer deleteHall = hallDAO.delete(hall);
      if (deleteHall > 0) {
        return deleteHall;
      } else {
        throw new NotDeletedException(ErrorMessage.HALL_NOT_DELETED);
      }
    } catch (SQLException e) {
      throw new NotDeletedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns object Hall wrapped in Optional by id
   *
   * @param id Hall id
   * @return Object Hall wrapped in Optional
   */
  @Override
  public Optional<Hall> getById(Long id) throws NotFoundException {
    try {
      Optional<Hall> oneById = hallDAO.getOneById(id);
      if (oneById.isPresent()) {
        return oneById;
      } else {
        throw new NotFoundException(ErrorMessage.HALL_NOT_FOUND);
      }
    } catch (SQLException e) {
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  /**
   * Method, that returns all objects of Hall
   *
   * @return list of Hall
   */
  @Override
  public List<Hall> getAll() throws NotFoundException {
    try {
      List<Hall> allHalls = hallDAO.getAll();
      if (!allHalls.isEmpty()) {
        return allHalls;
      } else {
        throw new NotFoundException(ErrorMessage.HALLS_NOT_FOUND);
      }
    } catch (SQLException e) {
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }
}
