package service.impl;

import dao.HallDAO;
import dao.databace.Database;
import dao.impl.JDBCHallDAO;
import entity.Hall;
import service.HallService;

import java.util.List;
import java.util.Optional;

public class HallServiceImpl implements HallService {
  private HallDAO hallDAO;

  public HallServiceImpl() {
    hallDAO = JDBCHallDAO.getInstance(Database.getConnection());
  }

  @Override
  public int save(Hall hall) {
    return hallDAO.save(hall);
  }

  @Override
  public int update(Hall hall) {
    return hallDAO.update(hall);
  }

  @Override
  public int delete(Hall hall) {
    return hallDAO.delete(hall);
  }

  @Override
  public Optional<Hall> getById(Long id) {
    return hallDAO.getOneById(id);
  }

  @Override
  public List<Hall> getAll() {
    return hallDAO.getAll();
  }
}
