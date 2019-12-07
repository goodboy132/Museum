package com.soft.museum.service.impl;

import com.soft.museum.dao.HallStyleDAO;
import com.soft.museum.dao.databace.Database;
import com.soft.museum.dao.impl.JDBCHallStyleDAO;
import com.soft.museum.entity.HallStyle;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;
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
      return hallStyleDAO.getOneById(id);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public int update(HallStyle hallStyle) throws NotUpdatedException {
    try {
      return hallStyleDAO.update(hallStyle);
    } catch (SQLException e) {
      throw new NotUpdatedException(e.getMessage());
    }
  }

  @Override
  public int delete(HallStyle hallStyle) throws NotDeletedException {
    try {
      return hallStyleDAO.delete(hallStyle);
    } catch (SQLException e) {
      throw new NotDeletedException(e.getMessage());
    }
  }

  @Override
  public List<HallStyle> getAll() throws NotFoundException {
    try {
      return hallStyleDAO.getAll();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }
}
