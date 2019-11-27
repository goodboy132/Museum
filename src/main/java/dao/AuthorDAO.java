package dao;

import entity.Author;

public class AuthorDAO extends ElementDAOImpl<Author> {
  public AuthorDAO() {
    super(Author.class);
  }
}
