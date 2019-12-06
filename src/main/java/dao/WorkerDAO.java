package dao;

import entity.Worker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface WorkerDAO extends GenericDAO<Worker> {
  List<Worker> getWorkersByPosition(String positionName);
  List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime,LocalDateTime endTime);
  Map<String ,Integer> getStatisticByExcursions();
}
