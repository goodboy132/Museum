package dao.impl;

import dao.ExcursionDAO;
import entity.Excursion;

import java.util.List;
import java.util.Optional;

public class JDBCExcursionDao implements ExcursionDAO {
  @Override
  public Integer save(Excursion element) {
    return null;
  }

  @Override
  public Integer update(Excursion element) {
    return null;
  }

  @Override
  public Integer delete(Excursion element) {
    return null;
  }

  @Override
  public Optional<Excursion> getOneById(Long elementId) {
    return Optional.empty();
  }

  @Override
  public List<Excursion> getAll() {
    return null;
  }
}
