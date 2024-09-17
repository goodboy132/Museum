package com.soft.museum.dao;

import com.soft.museum.entity.Worker;
import com.soft.museum.exception.NotFoundException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface WorkerDAO extends GenericDAO<Worker> {
  List<Worker> getWorkersByPosition(String positionName) throws SQLException;
  List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime,LocalDateTime endTime) throws SQLException;
  Map<String, Integer> getStatisticByExcursions() throws SQLException;
  Map<String, LocalDateTime> getStatisticAboutWorkedHours() throws SQLException;
}
