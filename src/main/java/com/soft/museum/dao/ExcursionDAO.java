package com.soft.museum.dao;

import com.soft.museum.entity.Excursion;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionDAO extends GenericDAO<Excursion> {
  List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws SQLException;
  Integer getCountOfExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) throws SQLException;
}
