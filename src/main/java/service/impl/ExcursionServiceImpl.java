package service.impl;

import dao.ExcursionDAO;
import dao.databace.Database;
import dao.impl.JDBCExcursionDao;
import entity.Excursion;
import service.ExcursionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ExcursionServiceImpl implements ExcursionService {
  private ExcursionDAO excursionDao;

  public ExcursionServiceImpl() {
    excursionDao = JDBCExcursionDao.getInstance(Database.getConnection());
  }

  @Override
  public int save(Excursion excursion) {
    return excursionDao.save(excursion);
  }

  @Override
  public int delete(Excursion excursion) {
    return excursionDao.delete(excursion);
  }

  @Override
  public int update(Excursion excursion) {
    return excursionDao.update(excursion);
  }

  @Override
  public Optional<Excursion> getById(Long id) {
    return excursionDao.getOneById(id);
  }

  @Override
  public List<Excursion> getAll() {
    return excursionDao.getAll();
  }

  @Override
  public List<Excursion> getAvailableExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) {
    return excursionDao.getAvailableExcursionsForPeriod(startTime, endTime);
  }

  @Override
  public Integer getCountOfExcursionsForPeriod(LocalDateTime startTime, LocalDateTime endTime) {
    return excursionDao.getCountOfExcursionsForPeriod(startTime, endTime);
  }
}
