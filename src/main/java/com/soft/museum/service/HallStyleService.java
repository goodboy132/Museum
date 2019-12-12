package com.soft.museum.service;

import com.soft.museum.entity.HallStyle;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface HallStyleService {
  /**
   * Method for saving object HallStyle in database
   *
   * @return 1 if the save was successful
   */
  int save(HallStyle hallStyle) throws NotSavedException;

  /**
   * Method, that returns object HallStyle wrapped in Optional by id
   *
   * @return Object HallStyle wrapped in Optional
   */
  Optional<HallStyle> getById(Long id) throws NotFoundException;

  /**
   * Method, that updates given object HallStyle
   *
   * @return 1 if the update was successful
   */
  int update(HallStyle hallStyle) throws NotUpdatedException;

  /**
   * Method, that deletes given object HallStyle
   *
   * @return 1 if the delete was successful
   */
  int delete(HallStyle hallStyle) throws NotDeletedException;

  /**
   * Method, that returns all objects of HallStyle
   *
   * @return list of HallStyle
   */
  List<HallStyle> getAll() throws NotFoundException;
}
