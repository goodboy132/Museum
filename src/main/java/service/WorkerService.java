package service;

import entity.Author;
import entity.Worker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface WorkerService {
  int save(Worker worker);
  int update(Worker worker);
  int delete(Worker worker);
  Optional<Worker> getOneById(Long id);
  List<Worker> getAll();
  List<Worker> getAllByPosition(String position);
  List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime, LocalDateTime endTime);
  Map<String, Integer> getStatisticByExcursions();
  Map<String, LocalDateTime> getStatisticAboutWorkedHours();
}
