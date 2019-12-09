package com.soft.museum.dao.impl;

import com.soft.museum.dao.MaterialDAO;
import com.soft.museum.dao.mapper.MaterialMapper;
import com.soft.museum.entity.Material;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCMaterialDAO implements MaterialDAO {

  private static JDBCMaterialDAO instance;
  private final Connection connection;

  public JDBCMaterialDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCMaterialDAO getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCMaterialDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(Material element) throws SQLException {
    String saveMaterialQuery = "INSERT INTO material(material_name) VALUES(?)";
    return JDBCCRADDao.save(connection, saveMaterialQuery, element.getName());
  }

  @Override
  public Integer update(Material element) throws SQLException {
    String updateMaterialQuery = "update material set material_name = ? where id = ?";
    return JDBCCRADDao.update(connection, updateMaterialQuery, element.getName(), element.getId());
  }

  @Override
  public Integer delete(Material element) throws SQLException {
    String deleteMaterialQuery = "delete from material where id = ?";
    return JDBCCRADDao.update(connection, deleteMaterialQuery, element.getId());
  }

  @Override
  public Optional<Material> getOneById(Long elementId) throws SQLException {
    String getOneMaterialQuery = "select * from material where id = ?";
    return JDBCCRADDao.getOne(connection, getOneMaterialQuery, new MaterialMapper(), elementId);
  }

  @Override
  public List<Material> getAll() throws SQLException {
    String getAllMaterialsQuery = "select * from material";
    return JDBCCRADDao.getAll(connection, getAllMaterialsQuery, new MaterialMapper());
  }
}
