package dao.impl;

import dao.AuthorDAO;
import dao.mapper.AuthorMapper;
import entity.Author;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class JDBCAuthorDao implements AuthorDAO {
  private static JDBCAuthorDao instance;
  private final Connection connection;


  public JDBCAuthorDao(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCAuthorDao getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCAuthorDao(connection);
    }
    return instance;
  }


  @Override
  public Integer save(Author author) {
    String saveQuery = "INSERT INTO author(name,surname,born_date,death_date) VALUES(?,?,?,?)";
    return JDBCCRADDao.save(connection, saveQuery,author.getFirstName(),author.getLastName(),
            author.getBornDate(),author.getDeathDate());
  }

  @Override
  public void update(Author element) {

  }

  @Override
  public void delete(Author element) {

  }

  @Override
  public Optional<Author> getOneById(Long elementId) {
    String getByIdQuery = "select * from author where author.id = ?";
    return JDBCCRADDao.getOneById(connection,getByIdQuery,elementId,new AuthorMapper());
  }

  @Override
  public List<Author> getAll() {
    return null;
  }
}
