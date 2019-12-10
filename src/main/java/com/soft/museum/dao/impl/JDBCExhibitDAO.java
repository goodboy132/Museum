package com.soft.museum.dao.impl;

import com.soft.museum.dao.ExhibitDAO;
import com.soft.museum.dao.mapper.*;
import com.soft.museum.entity.*;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JDBCExhibitDAO implements ExhibitDAO {
  private static JDBCExhibitDAO instance;
  private final Connection connection;


  private JDBCExhibitDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCExhibitDAO getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCExhibitDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(Exhibit exhibit) throws SQLException {
    String saveExhibitQuery = "INSERT INTO exhibit(exhibit_name,receipt_date,technique,description,author_id,hall_id)" +
            " VALUES(?,?,?,?,?,?)";
    return JDBCCRADDao.save(connection, saveExhibitQuery, exhibit.getName(), exhibit.getReceiptDate(),
            exhibit.getTechniques(), exhibit.getDescription(), exhibit.getAuthor().getId(), exhibit.getHall().getId());
  }

  @Override
  public Integer update(Exhibit exhibit) throws SQLException {
    String updateExhibitQuery = "UPDATE exhibit set exhibit_name = ?, receipt_date = ?, technique = ?," +
            " description = ?, author_id = ?, hall_id = ? WHERE id = ?";
    return JDBCCRADDao.save(connection, updateExhibitQuery, exhibit.getName(), exhibit.getReceiptDate(),
            exhibit.getTechniques(), exhibit.getDescription(), exhibit.getAuthor().getId(), exhibit.getHall().getId(),
            exhibit.getId());
  }

  @Override
  public Integer delete(Exhibit exhibit) throws SQLException {
    String deleteExhibitQuery = "DELETE FROM exhibit where exhibit.id = ?";
    return JDBCCRADDao.update(connection, deleteExhibitQuery, exhibit.getId());
  }


  @Override
  public Optional<Exhibit> getOneById(Long elementId) throws SQLException {
    String getExhibitByIdQuery = "select e.id,exhibit_name,e.receipt_date,e.description from exhibit e " +
            "where e.id = ?";
    Optional<Exhibit> exhibit = JDBCCRADDao.getOne(connection, getExhibitByIdQuery, new ExhibitMapper(), elementId);
    if (exhibit.isPresent()) {
      setMappedFieldsToExhibit(exhibit.get());
    }
    return exhibit;
  }

  @Override
  public List<Exhibit> getAll() throws SQLException {
    String getAllExhibitsQuery = "select e.id,exhibit_name,e.receipt_date,e.description from exhibit e";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllExhibitsQuery, new ExhibitMapper());
    for (Exhibit exhibit : exhibits) {
      setMappedFieldsToExhibit(exhibit);
    }
    return exhibits;
  }

  @Override
  public List<Exhibit> getAllByAuthor(Long authorId) throws SQLException {
    String getAllByAuthor = "select e.id,exhibit_name,e.receipt_date,e.description " +
            "from exhibit e where e.author_id = ?";
    return getAllBy(getAllByAuthor, authorId);
  }

  @Override
  public List<Exhibit> getAllByWorker(Long workerId) throws SQLException {
    String getAllByWorkerQuery = "select e.id,exhibit_name,e.receipt_date,e.description from exhibit e " +
            "join hall h on e.hall_id = h.id join worker_hall wh on h.id = wh.hall_id where wh.worker_id = ?";
    return getAllBy(getAllByWorkerQuery, workerId);
  }

  @Override
  public List<Exhibit> getAllByHole(Long hallId) throws SQLException {
    String getAllByHallQuery = "select e.id,exhibit_name,e.receipt_date,e.description from exhibit e " +
            "where e.hall_id = ?";
    return getAllBy(getAllByHallQuery, hallId);
  }

  @Override
  public Map<String, Integer> getStatisticByMaterial() throws SQLException {
    String getStatisticByMaterialQuery = "SELECT m.material_name as name, count(e.id) as count FROM " +
            "exhibit e JOIN exhibit_material em on e.id = em.exhibit_id join material m on em.material_id = m.id " +
            "group by material_name ";
    Optional<Map<String, Integer>> statistic = JDBCCRADDao.getOne(connection, getStatisticByMaterialQuery, new StatisticMapper());
    return statistic.get();
  }

  @Override
  public Map<String, Integer> getStatisticByTechnique() throws SQLException {
    String getStatisticByTechnique = "SELECT t.technique_name as name, count(e.id) as count FROM " +
            " exhibit e JOIN exhibit_technique et on e.id = et.exhibit_id join technique t on et.technique_id = t.id " +
            "group by t.technique_name;";
    Optional<Map<String, Integer>> statistic = JDBCCRADDao.getOne(connection, getStatisticByTechnique, new StatisticMapper());
    return statistic.get();
  }

  @Override
  public Map<String, Integer> getStatisticByAuthor() throws SQLException {
    String getStatisticByTechnique = "SELECT a.surname as name, count(a.id) as count " +
            "FROM exhibit e JOIN author a on a.id = e.author_id group by a.id";
    Optional<Map<String, Integer>> statistic = JDBCCRADDao.getOne(connection, getStatisticByTechnique, new StatisticMapper());
    return statistic.get();
  }

  @Override
  public Map<String, Integer> getStatisticByHall() throws SQLException {
    String getStatisticByTechnique = "SELECT h.hall_name as name, count(h.id) as count " +
            "FROM exhibit e JOIN hall h on h.id = e.hall_id group by h.id";
    Optional<Map<String, Integer>> statistic = JDBCCRADDao.getOne(connection, getStatisticByTechnique, new StatisticMapper());
    return statistic.get();
  }

  private void setMappedFieldsToExhibit(Exhibit exhibit) throws SQLException {
    setMaterialsForExhibit(exhibit);
    setAuthorForExhibit(exhibit);
    setHoleForExhibit(exhibit);
    setTechniquesForExhibit(exhibit);
  }


  private List<Exhibit> getAllBy(String query, Long parameter) throws SQLException {
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, query, new ExhibitMapper(), parameter);
    for (Exhibit exhibit : exhibits) {
      setMappedFieldsToExhibit(exhibit);
    }
    return exhibits;
  }


  private void setMaterialsForExhibit(Exhibit exhibit) throws SQLException {
    String getMaterialsByExhibitIdQuery = "select * from material  join exhibit_material on material.id = " +
            "exhibit_material.material_id where exhibit_material.exhibit_id = ?";
    List<Material> materials = JDBCCRADDao.getAll
            (connection, getMaterialsByExhibitIdQuery, new MaterialMapper(), exhibit.getId());
    exhibit.setMaterials(materials);
  }

  private void setAuthorForExhibit(Exhibit exhibit) throws SQLException {
    String getAuthorForExhibitQuery = "select * from author join exhibit on author.id = exhibit.author_id where " +
            "exhibit.id = ?";
    Optional<Author> author = JDBCCRADDao.getOne(
            connection, getAuthorForExhibitQuery, new AuthorMapper(), exhibit.getId());
    exhibit.setAuthor(author.get());
  }

  private void setHoleForExhibit(Exhibit exhibit) throws SQLException {
    String getHallForExhibitQuery = "select * from hall join exhibit on hall.id = exhibit.hall_id where " +
            "exhibit.id = ?";
    Optional<Hall> hall = JDBCCRADDao.getOne(connection, getHallForExhibitQuery, new HallMapper(), exhibit.getId());
    exhibit.setHall(hall.get());
  }

  private void setTechniquesForExhibit(Exhibit exhibit) throws SQLException {
    String getTechniquesForExhibitQuery = "select * from technique t join exhibit_technique et " +
            "on t.id = et.technique_id where et.exhibit_id = ? ";
    List<Technique> techniques = JDBCCRADDao.getAll(connection, getTechniquesForExhibitQuery,
            new TechniqueMapper(), exhibit.getId());
    exhibit.setTechniques(techniques);
  }
}
