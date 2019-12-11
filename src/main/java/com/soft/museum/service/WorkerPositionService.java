package com.soft.museum.service;

import com.soft.museum.entity.Worker;
import com.soft.museum.entity.WorkerPosition;
import com.soft.museum.exception.NotDeletedException;
import com.soft.museum.exception.NotFoundException;
import com.soft.museum.exception.NotSavedException;
import com.soft.museum.exception.NotUpdatedException;

import java.util.List;
import java.util.Optional;

public interface WorkerPositionService {
  int save(WorkerPosition workerPosition) throws NotSavedException;
  int update(WorkerPosition workerPosition) throws NotUpdatedException;
  int delete(WorkerPosition workerPosition) throws NotDeletedException;
  Optional<WorkerPosition> getOneById(Long id) throws NotFoundException;
  List<WorkerPosition> getAll() throws NotFoundException;
}
