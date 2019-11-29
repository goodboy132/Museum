package service.impl;

import dao.AuthorDAO;
import dao.databace.Database;
import dao.impl.JDBCAuthorDao;
import entity.Author;
import service.AuthorService;


public class AuthorServiceImpl implements AuthorService {
  private AuthorDAO authorDAO;

  public AuthorServiceImpl() {
    authorDAO = JDBCAuthorDao.getInstance(Database.getConnection());
  }

  @Override
  public int save(Author author) {
    return authorDAO.save(author);
  }
}
