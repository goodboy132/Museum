package service;

import entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
  int save(Author author);
  Optional<Author> getById(Long id);
  int update(Author author);
  int delete(Author author);
  List<Author> getAll();
}
