package dao.impl;

import dao.MaterialDAO;
import dao.mapper.MaterialMapper;
import entity.Material;

import java.sql.Connection;
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
  public Integer save(Material element) {
    String saveMaterialQuery = "INSERT INTO material(material_name) VALUES(?)";
    return JDBCCRADDao.save(connection, saveMaterialQuery, element.getName());
  }

  @Override
  public Integer update(Material element) {
    String updateMaterialQuery = "update material set material_name = ? where id = ?";
    return JDBCCRADDao.update(connection, updateMaterialQuery, element.getName(), element.getId());
  }

  @Override
  public Integer delete(Material element) {
    String deleteMaterialQuery = "delete from material where id = ?";
    return JDBCCRADDao.update(connection, deleteMaterialQuery, element.getId());
  }

  @Override
  public Optional<Material> getOneById(Long elementId) {
    String getOneMaterialQuery = "select * from material where id = ?";
    return JDBCCRADDao.getOne(connection, getOneMaterialQuery, elementId, new MaterialMapper());
  }

  @Override
  public List<Material> getAll() {
    String getAllMaterialsQuery = "select * from material";
    return JDBCCRADDao.getAll(connection, getAllMaterialsQuery, new MaterialMapper());
  }
}
