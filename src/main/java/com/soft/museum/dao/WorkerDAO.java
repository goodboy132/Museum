package com.soft.museum.dao;

import com.soft.museum.entity.Worker;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface WorkerDAO extends GenericDAO<Worker> {
  List<Worker> getWorkersByPosition(String positionName) throws SQLException;
  List<Worker> getFreeGuidesForPeriod(LocalDateTime startTime,LocalDateTime endTime) throws SQLException;
}
