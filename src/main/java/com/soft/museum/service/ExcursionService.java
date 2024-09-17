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
  int save(Excursion excursion) throws NotSavedException;
  int delete(Excursion excursion) throws NotDeletedException;
  int update(Excursion excursion) throws NotUpdatedException;
  Optional<Excursion> getById(Long id) throws NotFoundException;
  List<Excursion> getAll() throws NotFoundException;
  List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws NotFoundException;
  Integer getCountOfExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws NotFoundException;
}
