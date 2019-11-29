package service;

import entity.Author;

import java.util.Optional;

public interface AuthorService {
  int save(Author author);
  Optional<Author> getById(Long id);
}
