package service;

import entity.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerService {
  int save(Worker worker);
  int update(Worker worker);
  int delete(Worker worker);
  Optional<Worker> getOneById(Long id);
  List<Worker> getAll();
}
