package service.impl;

import dao.ExcursionTimeDAO;
import dao.databace.Database;
import dao.impl.JDBCExcursionTimeDAO;
import entity.ExcursionTime;
import service.ExcursionTimeService;

import java.util.List;
import java.util.Optional;

public class ExcursionTimeServiceImpl implements ExcursionTimeService {
  private ExcursionTimeDAO excursionTimeDAO;

  public ExcursionTimeServiceImpl() {
    excursionTimeDAO = JDBCExcursionTimeDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(ExcursionTime excursionTime) {
    return excursionTimeDAO.save(excursionTime);
  }

  @Override
  public int delete(ExcursionTime excursionTime) {
    return excursionTimeDAO.delete(excursionTime);
  }

  @Override
  public int update(ExcursionTime excursionTime) {
    return excursionTimeDAO.update(excursionTime);
  }

  @Override
  public Optional<ExcursionTime> getById(Long id) {
    return excursionTimeDAO.getOneById(id);
  }

  @Override
  public List<ExcursionTime> getAll() {
    return excursionTimeDAO.getAll();
  }
}
