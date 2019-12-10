package com.soft.museum.service.impl;

import com.soft.museum.constant.ErrorMessage;
import com.soft.museum.dao.AuthorDAO;
import com.soft.museum.dao.database.Database;
import com.soft.museum.dao.impl.JDBCAuthorDao;
import com.soft.museum.entity.Author;
import com.soft.museum.exception.*;
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
      Integer save = authorDAO.save(author);
      if (save > 0) {
        return true;
      } else {
        throw new NotSavedException(ErrorMessage.AUTHOR_NOT_SAVED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotSavedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public Optional<Author> getById(Long id) throws NotFoundException {
    try {
      Optional<Author> author = authorDAO.getOneById(id);
      if (author.isPresent()) {
        return author;
      } else {
        throw new NotFoundException(ErrorMessage.AUTHOR_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int update(Author author) throws NotUpdatedException {
    try {
      Integer update = authorDAO.update(author);
      if (update > 0 ) {
        return update;
      } else {
        throw new NotUpdatedException(ErrorMessage.AUTHOR_NOT_UPDATED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotUpdatedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override
  public int delete(Author author) throws NotDeletedException {
    try {
      Integer delete = authorDAO.delete(author);
      if (delete > 0) {
        return delete;
      } else {
        throw new NotDeletedException(ErrorMessage.AUTHOR_NOT_DELETED);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotDeletedException(ErrorMessage.SQL_EXCEPTION);
    }
  }

  @Override //need test
  public List<Author> getAll() throws NotFoundException {
    try {
      List<Author> allAuthors = authorDAO.getAll();
      if (!allAuthors.isEmpty()) {
        return allAuthors;
      } else {
        throw new NotFoundException(ErrorMessage.AUTHORS_NOT_FOUND);
      }
    } catch (SQLException e) {
      ExceptionLogger.getInstance().log(e.getLocalizedMessage());
      throw new NotFoundException(ErrorMessage.SQL_EXCEPTION);
    }
  }

}
