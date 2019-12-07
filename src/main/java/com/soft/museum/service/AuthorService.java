package com.soft.museum.service;

import com.soft.museum.entity.Author;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
  boolean save(Author author) throws NotSavedException;
  Optional<Author> getById(Long id) throws NotFoundException;
  int update(Author author) throws NotUpdatedException;
  int delete(Author author) throws NotDeletedException;
  List<Author> getAll() throws NotFoundException;
}
