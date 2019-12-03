package service.impl;

import dao.MaterialDAO;
import dao.databace.Database;
import dao.impl.JDBCMaterialDAO;
import entity.Material;
import service.MaterialService;

import java.util.List;
import java.util.Optional;

public class MaterialServiceImpl implements MaterialService {
  private MaterialDAO materialDAO;

  public MaterialServiceImpl() {
    materialDAO = JDBCMaterialDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(Material material) {
    return materialDAO.save(material);
  }

  @Override
  public int update(Material material) {
    return materialDAO.update(material);
  }

  @Override
  public int delete(Material material) {
    return materialDAO.delete(material);
  }

  @Override
  public Optional<Material> getById(Long id) {
    return materialDAO.getOneById(id);
  }

  @Override
  public List<Material> getAll() {
    return materialDAO.getAll();
  }
}
