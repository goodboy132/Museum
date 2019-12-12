package com.soft.museum.service;

import com.soft.museum.entity.Hall;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface HallService {
  /**
   * Method for saving object Hall in database
   *
   * @return 1 if the save was successful
   */
  int save(Hall hall) throws NotSavedException;

  /**
   * Method, that updates given object Hall
   *
   * @return 1 if the update was successful
   */
  int update(Hall hall) throws NotUpdatedException;

  /**
   * Method, that deletes given object Hall
   *
   * @return 1 if the delete was successful
   */
  int delete(Hall hall) throws NotDeletedException;

  /**
   * Method, that returns object Hall wrapped in Optional by id
   *
   * @param id Hall id
   * @return Object Hall wrapped in Optional
   */
  Optional<Hall> getById(Long id) throws NotFoundException;

  /**
   * Method, that returns all objects of Hall
   *
   * @return list of Hall
   */
  List<Hall> getAll() throws NotFoundException;
}
