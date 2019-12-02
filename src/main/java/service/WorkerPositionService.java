package service;

import entity.WorkerPosition;

import java.util.List;
import java.util.Optional;

public interface WorkerPositionService {
  int save(WorkerPosition workerPosition);
  int update(WorkerPosition workerPosition);
  int delete(WorkerPosition workerPosition);
  Optional<WorkerPosition> getOneById(Long id);
  List<WorkerPosition> getAll();
}
