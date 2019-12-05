package dao.impl;

import dao.ExhibitDAO;
import dao.mapper.AuthorMapper;
import dao.mapper.ExhibitMapper;
import dao.mapper.HallMapper;
import dao.mapper.MaterialMapper;
import entity.Exhibit;
import entity.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
  public Integer save(Exhibit exhibit) {
    String saveExhibitQuery = "INSERT INTO exhibit(exhibit_name,receipt_date,technique,description,author_id,hall_id)" +
            " VALUES(?,?,?,?,?,?)";
    return JDBCCRADDao.save(connection, saveExhibitQuery, exhibit.getName(), exhibit.getReceiptDate(),
            exhibit.getTechnique(), exhibit.getDescription(), exhibit.getAuthor().getId(), exhibit.getHall().getId());
  }

  @Override
  public Integer update(Exhibit exhibit) {
    String updateExhibitQuery = "UPDATE exhibit set exhibit_name = ?, receipt_date = ?, technique = ?," +
            " description = ?, author_id = ?, hall_id = ? WHERE id = ?";
    return JDBCCRADDao.save(connection, updateExhibitQuery, exhibit.getName(), exhibit.getReceiptDate(),
            exhibit.getTechnique(), exhibit.getDescription(), exhibit.getAuthor().getId(), exhibit.getHall().getId(),
            exhibit.getId());
  }

  @Override
  public Integer delete(Exhibit exhibit) {
    String deleteExhibitQuery = "DELETE FROM author where author.id = ?";
    return JDBCCRADDao.update(connection, deleteExhibitQuery, exhibit.getId());
  }


  @Override
  public Optional<Exhibit> getOneById(Long elementId) {
    String getExhibitByIdQuery = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description from exhibit e " +
            "where e.id = ?";
    Optional<Exhibit> exhibit = JDBCCRADDao.getOneById(connection, getExhibitByIdQuery, elementId, new ExhibitMapper());
    exhibit.ifPresent(this::setMappedFieldsToExhibit);
    return exhibit;
  }

  @Override
  public List<Exhibit> getAll() {
    String getAllExhibitsQuery = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description from exhibit e";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllExhibitsQuery, new ExhibitMapper());
    exhibits.forEach(this::setMappedFieldsToExhibit);
    return exhibits;
  }

  @Override
  public List<Exhibit> getAllByAuthor(Long authorId) {
    String getAllExhibitsByAuthor = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description " +
            "from exhibit e where e.author_id = ?";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllExhibitsByAuthor, new ExhibitMapper(), authorId);
    exhibits.forEach(this::setMappedFieldsToExhibit);
    return exhibits;
  }

  @Override
  public List<Exhibit> getAllByWorker(Long workerId) {
    String getAllByWorkerQuery = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description from exhibit e " +
            "join hall h on e.hall_id = h.id join worker_hall wh on h.id = wh.hall_id where wh.worker_id = ?";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllByWorkerQuery, new ExhibitMapper(), workerId);
    exhibits.forEach(this::setMappedFieldsToExhibit);
    return exhibits;
  }
  @Override
  public List<Exhibit> getAllByHole(Long hallId) {
    String getAllByWorkerQuery = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description from exhibit e " +
            "where e.hall_id = ?";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllByWorkerQuery, new ExhibitMapper(), hallId);
    exhibits.forEach(this::setMappedFieldsToExhibit);
    return exhibits;
  }


  private void setMappedFieldsToExhibit(Exhibit exhibit) {
    getMaterialsForExhibit(exhibit);
    getAuthorForExhibit(exhibit);
    getHoleForExhibit(exhibit);
  }


  private void getMaterialsForExhibit(Exhibit exhibit) {
    List<Material> materials = new ArrayList<>();
    String getMaterialsByExhibitIdQuery = "select * from material  join exhibit_material on material.id = " +
            "exhibit_material.material_id where exhibit_material.exhibit_id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(getMaterialsByExhibitIdQuery);
      JDBCCRADDao.addParametersToPreparedStatement(preparedStatement, exhibit.getId());
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        materials.add(new MaterialMapper().extractFromResultSet(resultSet));
      }
      exhibit.setMaterials(materials);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void getAuthorForExhibit(Exhibit exhibit) {
    String getAuthorForExhibitQuery = "select * from author join exhibit on author.id = exhibit.author_id where " +
            "exhibit.id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(getAuthorForExhibitQuery);
      JDBCCRADDao.addParametersToPreparedStatement(preparedStatement, exhibit.getId());
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        exhibit.setAuthor(new AuthorMapper().extractFromResultSet(resultSet));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void getHoleForExhibit(Exhibit exhibit) {
    String getHallForExhibitQuery = "select * from hall join exhibit on hall.id = exhibit.hall_id where " +
            "exhibit.id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(getHallForExhibitQuery);
      JDBCCRADDao.addParametersToPreparedStatement(preparedStatement, exhibit.getId());
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        exhibit.setHall(new HallMapper().extractFromResultSet(resultSet));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
