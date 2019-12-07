package com.soft.museum.service.impl;

import com.soft.museum.dao.MaterialDAO;
import com.soft.museum.dao.databace.Database;
import com.soft.museum.dao.impl.JDBCMaterialDAO;
import com.soft.museum.entity.Material;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;
import com.soft.museum.service.MaterialService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MaterialServiceImpl implements MaterialService {
  private MaterialDAO materialDAO;

  public MaterialServiceImpl() {
    materialDAO = JDBCMaterialDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(Material material) throws NotSavedException {
    try {
      return materialDAO.save(material);
    } catch (SQLException e) {
      throw new NotSavedException(e.getMessage());
    }
  }

  @Override
  public int update(Material material) throws NotUpdatedException {
    try {
      return materialDAO.update(material);
    } catch (SQLException e) {
      throw new NotUpdatedException(e.getMessage());
    }
  }

  @Override
  public int delete(Material material) throws NotDeletedException {
    try {
      return materialDAO.delete(material);
    } catch (SQLException e) {
      throw new NotDeletedException(e.getMessage());
    }
  }

  @Override
  public Optional<Material> getById(Long id) throws NotFoundException {
    try {
      return materialDAO.getOneById(id);
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public List<Material> getAll() throws NotFoundException {
    try {
      return materialDAO.getAll();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }
}
