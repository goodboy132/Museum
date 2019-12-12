package com.soft.museum.service;

import com.soft.museum.entity.Worker;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface WorkerService {
  /**
   * Method for saving object Worker in database
   *
   * @return true if the save was successful
   */
  int save(Worker worker) throws NotSavedException;

  /**
   * Method, that updates given object Worker
   *
   * @return 1 if the update was successful
   */
  int update(Worker worker) throws NotUpdatedException;

  /**
   * Method, that deletes given object Worker
   *
   * @return 1 if the delete was successful
   */
  int delete(Worker worker) throws NotDeletedException;

  /**
   * Method, that returns object Worker wrapped in Optional by id
   *
   * @param id Worker id
   * @return Object Worker wrapped in Optional
   */
  Optional<Worker> getOneById(Long id) throws NotFoundException;

  /**
   * Method, that returns all objects of Workers
   *
   * @return list of Workers
   */
  List<Worker> getAll() throws NotFoundException;

  /**
   * Method, that returns all objects of Workers by there position
   *
   * @return list of Exhibits by worker
   */
  List<Worker> getAllByPosition(String position) throws NotFoundException;

  /**
   * Method, that returns count of Workers, which don't have excursions in period
   * from startTime to endTime
   *
   * @param startTime start time of period
   * @param endTime   end time of period
   * @return list of Workers in this period
   */
  List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws NotFoundException;

  /**
   * Method, that returns statistic about count of excursions
   *
   * @return map where key is name of Worker, value is there count
   */
  Map<String, Integer> getStatisticByExcursions() throws NotFoundException;

  /**
   * Method, that returns statistic about worked hours
   *
   * @return map where key is name of Worker, value is  count of his worked hours
   */
  Map<String, LocalDateTime> getStatisticAboutWorkedHours() throws NotFoundException;
}
