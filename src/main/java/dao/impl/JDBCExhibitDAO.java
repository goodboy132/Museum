package dao.impl;

import dao.AuthorDAO;
import dao.ExhibitDAO;
import dao.mapper.ExhibitMapper;
import entity.Exhibit;

import java.sql.Connection;
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
  public Integer save(Exhibit element) {
    return null;
  }

  @Override
  public void update(Exhibit element) {

  }

  @Override
  public void delete(Exhibit element) {

  }

  @Override
  public Optional<Exhibit> getOneById(Long elementId) {
    return Optional.empty();
  }

  @Override
  public List<Exhibit> getAll() {
    String query = "select * from exhibit join exhbit_material" +
            " em on exhibit.id = em.exibit_id join material m on em.material_id = m.id";
    return JDBCCRADDao.getAll(connection,query,new ExhibitMapper());
  }
}
