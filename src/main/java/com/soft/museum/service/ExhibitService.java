package com.soft.museum.service;


import com.soft.museum.entity.Exhibit;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Map;

public interface ExhibitService {
  /**
   * Method for saving object Exhibit in database
   *
   * @return true if the save was successful
   */
  int save(Exhibit exhibit) throws NotSavedException;
  /**
   * Method, that updates given object Exhibit
   *
   * @return 1 if the update was successful
   */
  int update(Exhibit exhibit) throws NotUpdatedException;
  /**
   * Method, that deletes given object Exhibit
   *
   * @return 1 if the delete was successful
   */
  int delete(Exhibit exhibit) throws NotDeletedException;
  /**
   * Method, that returns object Exhibit wrapped in Optional by id
   *
   * @return Object Exhibit wrapped in Optional
   */
  Exhibit getById(Long id) throws NotFoundException;
  /**
   * Method, that returns all objects of Exhibits
   *
   * @return list of Exhibits
   */
  List<Exhibit> getAll() throws NotFoundException;
  /**
   * Method, that returns all objects of Exhibits by author
   *
   * @param id Author id
   * @return list of Exhibits by author
   */
  List<Exhibit> getAllByAuthor(Long id) throws NotFoundException;
  /**
   * Method, that returns all objects of Exhibits by worker
   *
   * @param id Worker id
   * @return list of Exhibits by worker
   */
  List<Exhibit> getAllByWorker(Long id) throws NotFoundException;
  /**
   * Method, that returns all objects of Exhibits by hall
   *
   * @param id Hall id
   * @return list of Exhibits by hall
   */
  List<Exhibit> getAllByHall(Long id) throws NotFoundException;
  /**
   * Method, that returns statistic by exhibit's material
   *
   * @return map where key is name of Exhibit, value is there count
   */
  Map<String,Integer> getStatisticByMaterial() throws NotFoundException;
  /**
   * Method, that returns statistic by exhibit's technique
   *
   * @return map where key is name of Exhibit, value is there count
   */
  Map<String,Integer> getStatisticByTechnique() throws NotFoundException;
  /**
   * Method, that returns statistic by exhibit's author
   *
   * @return map where key is name of Exhibit, value is there count
   */
  Map<String,Integer> getStatisticByAuthor() throws NotFoundException;
  /**
   * Method, that returns statistic by exhibit's hall
   *
   * @return map where key is name of Exhibit, value is there count
   */
  Map<String,Integer> getStatisticByHall() throws NotFoundException;
}
