package com.soft.museum.service.impl;

import com.soft.museum.dao.HallDAO;
import com.soft.museum.dao.databace.Database;
import com.soft.museum.dao.impl.JDBCHallDAO;
import com.soft.museum.entity.Hall;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;
import com.soft.museum.service.HallService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class HallServiceImpl implements HallService {
  private HallDAO hallDAO;

  public HallServiceImpl() {
    hallDAO = JDBCHallDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(Hall hall) throws NotSavedException {
    try {
      return hallDAO.save(hall);
    } catch (SQLException e) {
      throw new NotSavedException(e.getMessage());
    }
  }

  @Override
  public int update(Hall hall) throws NotUpdatedException {
    try {
      return hallDAO.update(hall);
    } catch (SQLException e) {
      throw new NotUpdatedException(e.getMessage());
    }
  }

  @Override
  public int delete(Hall hall) throws NotDeletedException {
    try {
      return hallDAO.delete(hall);
    } catch (SQLException e) {
      throw new NotDeletedException(e.getMessage());
    }
  }

  @Override
  public Optional<Hall> getById(Long id) throws NotFoundException {
    try {
      return hallDAO.getOneById(id);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Hall> getAll() throws NotFoundException {
    try {
      return hallDAO.getAll();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }
}
