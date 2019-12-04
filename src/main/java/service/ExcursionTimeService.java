package service;

import entity.ExcursionTime;

import java.util.List;
import java.util.Optional;

public interface ExcursionTimeService {
  int save(ExcursionTime excursionTime);
  int delete(ExcursionTime excursionTime);
  int update(ExcursionTime excursionTime);
  Optional<ExcursionTime> getById(Long id);
  List<ExcursionTime> getAll();
}
