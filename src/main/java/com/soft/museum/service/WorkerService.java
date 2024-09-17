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
  int save(Worker worker) throws NotSavedException;
  int update(Worker worker) throws NotUpdatedException;
  int delete(Worker worker) throws NotDeletedException;
  Optional<Worker> getOneById(Long id) throws NotFoundException;
  List<Worker> getAll() throws NotFoundException;
  List<Worker> getAllByPosition(String position) throws NotFoundException;
  List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws NotFoundException;
  Map<String, Integer> getStatisticByExcursions() throws NotFoundException;
  Map<String, LocalDateTime> getStatisticAboutWorkedHours() throws NotFoundException;
}
