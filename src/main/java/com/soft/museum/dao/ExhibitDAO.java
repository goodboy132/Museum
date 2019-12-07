package com.soft.museum.dao;

import com.soft.museum.entity.Exhibit;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ExhibitDAO extends GenericDAO<Exhibit> {
  List<Exhibit>getAllByAuthor(Long authorId) throws SQLException;
  List<Exhibit>getAllByWorker(Long workerId) throws SQLException;
  List<Exhibit>getAllByHole(Long workerId) throws SQLException;
  Map<String,Integer>getStatisticByMaterial() throws SQLException;
  Map<String,Integer>getStatisticByTechnique() throws SQLException;
  Map<String,Integer> getStatisticByAuthor() throws SQLException;
  Map<String,Integer> getStatisticByHall() throws SQLException;
}
