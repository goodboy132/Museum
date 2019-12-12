package com.soft.museum.dao.impl;

import com.soft.museum.dao.AuthorDAO;
import com.soft.museum.dao.mapper.AuthorMapper;
import com.soft.museum.entity.Author;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Class, that implements special methods for
 * getting / updating Author objects from / in database.
 */
public class JDBCAuthorDao implements AuthorDAO {
  private static JDBCAuthorDao instance;
  private final Connection connection;


  private JDBCAuthorDao(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCAuthorDao getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCAuthorDao(connection);
    }
    return instance;
  }

  /**
   * Method for saving object Author in database
   *
   * @return true if the save was successful
   */
  @Override
  public Integer save(Author author) throws SQLException {
    String saveQuery = "INSERT INTO author(name,surname,born_date,death_date) VALUES(?,?,?,?)";
    return JDBCCRUDDao.save(connection, saveQuery, author.getFirstName(), author.getLastName(),
            author.getBornDate(), author.getDeathDate());
  }

  /**
   * Method, that updates given object Author
   *
   * @return 1 if the update was successful
   */
  @Override
  public Integer update(Author element) throws SQLException {
    String updateQuery = "UPDATE author set name = ?, surname = ?, born_date = ?, death_date = ? WHERE id = ?";
    return JDBCCRUDDao.update(connection, updateQuery, element.getFirstName(), element.getLastName(),
            element.getBornDate(), element.getDeathDate(), element.getId());
  }

  /**
   * Method, that deletes given object Author
   *
   * @return 1 if the delete was successful
   */
  @Override
  public Integer delete(Author element) throws SQLException {
    String deleteQuery = "DELETE FROM author where author.id = ?";
    return JDBCCRUDDao.update(connection, deleteQuery, element.getId());
  }

  /**
   * Method, that returns object Author wrapped in Optional by id
   *
   * @return Object Author wrapped in Optional
   */
  @Override
  public Optional<Author> getOneById(Long elementId) throws SQLException {
    String getByIdQuery = "select * from author where author.id = ?";
    return JDBCCRUDDao.getOne(connection, getByIdQuery, new AuthorMapper(), elementId);
  }

  /**
   * Method, that returns all objects of Author
   *
   * @return list of Author
   */
  @Override
  public List<Author> getAll() throws SQLException {
    String getAllQuery = "select * from author";
    return JDBCCRUDDao.getAll(connection, getAllQuery, new AuthorMapper());
  }
}
