package com.soft.museum.service;

import com.soft.museum.entity.Author;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
  /**
   * Method for saving object Author in database
   *
   * @return true if the save was successful
   */
  boolean save(Author author) throws NotSavedException;

  /**
   * Method, that returns object Author wrapped in Optional by id
   *
   * @return Object Author wrapped in Optional
   */
  Optional<Author> getById(Long id) throws NotFoundException;

  /**
   * Method, that updates given object Author
   *
   * @return 1 if the update was successful
   */
  int update(Author author) throws NotUpdatedException;

  /**
   * Method, that deletes given object Author
   *
   * @return 1 if the delete was successful
   */
  int delete(Author author) throws NotDeletedException;

  /**
   * Method, that returns all objects of Author
   *
   * @return list of Author
   */
  List<Author> getAll() throws NotFoundException;
}
