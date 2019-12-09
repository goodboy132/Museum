package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.HallStyleDAO;
import com.soft.museum.dao.databace.Database;
import com.soft.museum.dao.impl.JDBCHallStyleDAO;
import com.soft.museum.entity.HallStyle;
import com.soft.museum.exception.*;
import com.soft.museum.service.HallStyleService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class HallStyleServiceImpl implements HallStyleService {
  private HallStyleDAO hallStyleDAO;

  HallStyleServiceImpl() {
    hallStyleDAO = JDBCHallStyleDAO.getInstance(Database.getConnection());
  }


  @Override
  public int save(HallStyle hallStyle) throws NotSavedException {
    try {
      return hallStyleDAO.save(hallStyle);
    } catch (SQLException e) {
      throw new NotSavedException(e.getMessage());
    }
  }

  @Override
  public Optional<HallStyle> getById(Long id) throws NotFoundException {
    try {
      Optional<HallStyle> oneById = hallStyleDAO.getOneById(id);
      if (oneById.isPresent()) {
        return oneById;
      } else {
        throw new NotFoundException(ErrorMessage.HALL_STYLE_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int update(HallStyle hallStyle) throws NotUpdatedException {
    try {
      Integer update = hallStyleDAO.update(hallStyle);
      if (update > 0) {
        return update;
      } else {
        throw new NotUpdatedException(ErrorMessage.HALL_STYLE_NOT_UPDATED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotUpdatedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int delete(HallStyle hallStyle) throws NotDeletedException {
    try {
      Integer deleteHallStyle = hallStyleDAO.delete(hallStyle);
      if (deleteHallStyle > 0) {
        return deleteHallStyle;
      } else {
        throw new NotDeletedException(ErrorMessage.HALL_STYLE_NOT_DELETED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotDeletedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<HallStyle> getAll() throws NotFoundException {
    try {
      List<HallStyle> all = hallStyleDAO.getAll();
      if (!all.isEmpty()) {
        return all;
      } else {
        throw new NotFoundException(ErrorMessage.HALL_STYLES_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }
}
