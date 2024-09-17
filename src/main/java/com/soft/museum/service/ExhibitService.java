package com.soft.museum.service;


import com.soft.museum.entity.Exhibit;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Map;

public interface ExhibitService {
  int save(Exhibit exhibit) throws NotSavedException;
  int update(Exhibit exhibit) throws NotUpdatedException;
  int delete(Exhibit exhibit) throws NotDeletedException;
  Exhibit getById(Long id) throws NotFoundException;
  List<Exhibit> getAll() throws NotFoundException;
  List<Exhibit> getAllByAuthor(Long id) throws NotFoundException;
  List<Exhibit> getAllByWorker(Long id) throws NotFoundException;
  List<Exhibit> getAllByHall(Long id) throws NotFoundException;
  Map<String,Integer> getStatisticByMaterial() throws NotFoundException;
  Map<String,Integer> getStatisticByTechnique() throws NotFoundException;
  Map<String,Integer> getStatisticByAuthor() throws NotFoundException;
  Map<String,Integer> getStatisticByHall() throws NotFoundException;
}
