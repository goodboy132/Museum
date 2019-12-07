package com.soft.museum.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<E> {
  Integer save(E element) throws SQLException;
  Integer update(E element) throws SQLException;
  Integer delete(E element) throws SQLException;
  Optional<E> getOneById(Long elementId) throws SQLException;
  List<E> getAll() throws SQLException;
}
