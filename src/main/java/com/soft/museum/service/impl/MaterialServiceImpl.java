package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.MaterialDAO;
import com.soft.museum.dao.database.Database;
import com.soft.museum.dao.impl.JDBCMaterialDAO;
import com.soft.museum.entity.Material;
import com.soft.museum.exception.*;
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
      Integer save = materialDAO.save(material);
      if (save > 0) {
        return save;
      } else {
        throw new NotSavedException(ErrorMessage.MATERIAL_NOT_SAVED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotSavedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int update(Material material) throws NotUpdatedException {
    try {
      Integer update = materialDAO.update(material);
      if (update > 0) {
        return update;
      } else {
        throw new NotUpdatedException(ErrorMessage.MATERIAL_NOT_UPDATED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotUpdatedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int delete(Material material) throws NotDeletedException {
    try {
      Integer deleteMaterial = materialDAO.delete(material);
      if (deleteMaterial > 0) {
        return deleteMaterial;
      } else {
        throw new NotDeletedException(ErrorMessage.MATERIAL_NOT_DELETED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotDeletedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Optional<Material> getById(Long id) throws NotFoundException {
    try {
      Optional<Material> oneById = materialDAO.getOneById(id);
      if (oneById.isPresent()) {
        return oneById;
      } else {
        throw new NotFoundException(ErrorMessage.MATERIAL_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public List<Material> getAll() throws NotFoundException {
    try {
      List<Material> all = materialDAO.getAll();
      if (!all.isEmpty()) {
        return all;
      } else {
        throw new NotFoundException(ErrorMessage.MATERIALS_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(e.getMessage());
    }
  }
}
