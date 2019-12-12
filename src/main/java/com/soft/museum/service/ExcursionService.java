package com.soft.museum.service;

import com.soft.museum.entity.Excursion;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ExcursionService {
  /**
   * Method for saving object Excursion in database
   *
   * @return 1 if the save was successful
   */
  int save(Excursion excursion) throws NotSavedException;

  /**
   * Method, that deletes given object Excursion
   *
   * @return 1 if the delete was successful
   */
  int delete(Excursion excursion) throws NotDeletedException;

  /**
   * Method, that updates given object Excursion
   *
   * @return 1 if the update was successful
   */
  int update(Excursion excursion) throws NotUpdatedException;

  /**
   * Method, that returns object Excursion wrapped in Optional by id
   *
   * @return Object Author wrapped in Optional
   */
  Optional<Excursion> getById(Long id) throws NotFoundException;

  /**
   * Method, that returns all objects of Excursion
   *
   * @return list of Excursion
   */
  List<Excursion> getAll() throws NotFoundException;

  /**
   * Method, that returns all objects of Excursions, which held in period from startTime to endTime
   *
   * @param startTime time when excursion starts
   * @param endTime   time when excursion ends
   * @return list of Excursions in this period
   */
  List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws NotFoundException;

  /**
   * Method, that returns count of Excursions, which held in period from startTime to endTime
   *
   * @param startTime time when excursion starts
   * @param endTime   time when excursion ends
   * @return count of Excursions in this period
   */
  Integer getCountOfExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws NotFoundException;
}
