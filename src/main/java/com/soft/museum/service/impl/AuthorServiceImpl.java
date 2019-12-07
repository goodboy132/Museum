package com.soft.museum.service.impl;

import com.soft.museum.dao.AuthorDAO;
import com.soft.museum.dao.databace.Database;
import com.soft.museum.dao.impl.JDBCAuthorDao;
import com.soft.museum.entity.Author;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;
import com.soft.museum.service.AuthorService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class AuthorServiceImpl implements AuthorService {
  private AuthorDAO authorDAO;

  AuthorServiceImpl() {
    authorDAO = JDBCAuthorDao.getInstance(Database.getConnection());
  }

  @Override
  public boolean save(Author author) throws NotSavedException {
    try {
      authorDAO.save(author);
      return true;
    } catch (SQLException e) {
      throw new NotSavedException(e.getMessage());
    }
  }

  @Override
  public Optional<Author> getById(Long id) throws NotFoundException {
    try {
      Optional<Author> author = authorDAO.getOneById(id);
      return author;
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

  @Override
  public int update(Author author) throws NotUpdatedException {
    try {
      return authorDAO.update(author);
    } catch (SQLException e) {
      throw new NotUpdatedException(e.getMessage());
    }
  }

  @Override
  public int delete(Author author) throws NotDeletedException {
    try {
      return authorDAO.delete(author);
    } catch (SQLException e) {
      throw new NotDeletedException(e.getMessage());
    }
  }

  @Override
  public List<Author> getAll() throws NotFoundException {
    try {
      return authorDAO.getAll();
    } catch (SQLException e) {
      throw new NotFoundException(e.getMessage());
    }
  }

}
