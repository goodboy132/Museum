package service.impl;

import dao.AuthorDAO;
import dao.databace.Database;
import dao.impl.JDBCAuthorDao;
import entity.Author;
import service.AuthorService;

import java.util.List;
import java.util.Optional;


public class AuthorServiceImpl implements AuthorService {
  private AuthorDAO authorDAO;

  AuthorServiceImpl() {
    authorDAO = JDBCAuthorDao.getInstance(Database.getConnection());
  }

  @Override
  public int save(Author author) {
    return authorDAO.save(author);
  }

  @Override
  public Optional<Author> getById(Long id) {
    return authorDAO.getOneById(id);
  }

  @Override
  public int update(Author author) {
    return authorDAO.update(author);
  }

  @Override
  public int delete(Author author) {
    return authorDAO.delete(author);
  }

  @Override
  public List<Author> getAll() {
    return authorDAO.getAll();
  }


}
