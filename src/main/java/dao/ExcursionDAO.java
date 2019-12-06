package dao;

import entity.Excursion;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionDAO extends GenericDAO<Excursion> {
  List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime);
}
