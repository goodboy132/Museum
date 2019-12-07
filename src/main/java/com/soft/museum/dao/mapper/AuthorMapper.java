package com.soft.museum.dao.mapper;

import com.soft.museum.entity.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements ObjectMapper<Author> {
  @Override
  public Author extractFromResultSet(ResultSet resultSet) throws SQLException {
    Author author = new Author();
    author.setId(resultSet.getLong("id"));
    author.setFirstName(resultSet.getString("name"));
    author.setLastName(resultSet.getString("surname"));
    author.setBornDate(resultSet.getTimestamp("born_date").toLocalDateTime());
    author.setDeathDate(resultSet.getTimestamp("death_date").toLocalDateTime());
    return author;
  }
}
