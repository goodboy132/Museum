package dao.impl;

import dao.AuthorDAO;
import dao.ExhibitDAO;
import dao.mapper.ExhibitMapper;
import entity.Author;
import entity.Exhibit;
import entity.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class JDBCExhibitDAO implements ExhibitDAO {
  private static JDBCExhibitDAO instance;
  private final Connection connection;


  private JDBCExhibitDAO(Connection connection){
    this.connection = connection;
  }

  public synchronized static JDBCExhibitDAO getInstance(Connection connection){
    if (instance == null){
      instance = new JDBCExhibitDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(Exhibit exhibit) {
    String saveExhibitQuery = "INSERT INTO exhibit(exhibit_name,receipt_date,technique,description,author_id,hall_id)" +
            " VALUES(?,?,?,?,?,?)";
    return JDBCCRADDao.save(connection,saveExhibitQuery,exhibit.getName(),exhibit.getReceiptDate(),
            exhibit.getTechnique(),exhibit.getDescription(),exhibit.getAuthor().getId(),exhibit.getHall().getId());
  }

  @Override
  public Integer update(Exhibit exhibit) {
    String updateExhibitQuery = "UPDATE exhibit set exhibit_name = ?, receipt_date = ?, technique = ?," +
            " description = ?, author_id = ?, hall_id = ? WHERE id = ?";
    return JDBCCRADDao.save(connection,updateExhibitQuery,exhibit.getName(),exhibit.getReceiptDate(),
            exhibit.getTechnique(),exhibit.getDescription(),exhibit.getAuthor().getId(),exhibit.getHall().getId(),
            exhibit.getId());
  }

  @Override
  public Integer delete(Exhibit exhibit) {
    String deleteExhibitQuery = "DELETE FROM author where author.id = ?";
    return JDBCCRADDao.update(connection,deleteExhibitQuery,exhibit.getId());
  }


  @Override
  public Optional<Exhibit> getOneById(Long elementId) {
    String getExhibitByIdQuery = "select * from author where author.id = ?";
    return JDBCCRADDao.getOneById(connection,getExhibitByIdQuery,elementId,new ExhibitMapper());
  }

  @Override
  public List<Exhibit> getAll() {
    String getAllExhibitsQuery = "select * from exhibit join exhbit_material" +
            " em on exhibit.id = em.exibit_id join material m on em.material_id = m.id";
    return JDBCCRADDao.getAll(connection,getAllExhibitsQuery,new ExhibitMapper());
  }

  @Override
  public List<Exhibit> getAllByAuthor(int authorId) {
    String getAllExhibitsByAuthor = "select * from exhibit e where e.author_id = ?";
    List<Exhibit> exhibitsByAuthor = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(getAllExhibitsByAuthor);
      JDBCCRADDao.addParametersToPreparedStatement(preparedStatement, authorId);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        exhibitsByAuthor.add(new ExhibitMapper().extractFromResultSet(resultSet));
      }
      return exhibitsByAuthor;
    }
    catch (SQLException e){
      e.printStackTrace();
      throw new RuntimeException();
    }
  }
}
