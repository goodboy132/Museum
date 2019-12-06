package service;

import entity.Excursion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ExcursionService {
  int save(Excursion excursion);
  int delete(Excursion excursion);
  int update(Excursion excursion);
  Optional<Excursion> getById(Long id);
  List<Excursion> getAll();
  List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime);
}
