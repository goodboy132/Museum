package com.soft.museum.service;

import com.soft.museum.entity.Material;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
  /**
   * Method for saving object Material in database
   *
   * @return 1 if the save was successful
   */
  int save(Material material) throws NotSavedException;

  /**
   * Method, that updates given object Material
   *
   * @return 1 if the update was successful
   */
  int update(Material material) throws NotUpdatedException;

  /**
   * Method, that deletes given object Material
   *
   * @return 1 if the delete was successful
   */
  int delete(Material material) throws NotDeletedException;

  /**
   * Method, that returns object Material wrapped in Optional by id
   *
   * @param id Material id
   * @return Object Material wrapped in Optional
   */
  Optional<Material> getById(Long id) throws NotFoundException;

  /**
   * Method, that returns all objects of Material
   *
   * @return list of Materials
   */
  List<Material> getAll() throws NotFoundException;
}
